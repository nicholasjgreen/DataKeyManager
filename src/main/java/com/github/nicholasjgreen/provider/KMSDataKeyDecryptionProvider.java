package com.github.nicholasjgreen.provider;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.*;
import com.github.nicholasjgreen.dto.DecryptDataKeyResponse;
import com.github.nicholasjgreen.errors.DataKeyDecryptionFailure;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

@Service
@Profile("KMS")
public class KMSDataKeyDecryptionProvider implements DataKeyDecryptionProvider {
    private static final int IV_SIZE = 16;
    private AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();
    private Base64.Encoder encoder = Base64.getEncoder();
    private Base64.Decoder decoder = Base64.getDecoder();

    public DecryptDataKeyResponse decryptDataKey(String dataKeyEncryptionKeyId, String ciphertextDataKey) {

        ByteBuffer ciphertextDataKeyBuffer = ByteBuffer.wrap(decoder.decode(ciphertextDataKey));
        DecryptRequest req = new DecryptRequest().withCiphertextBlob(ciphertextDataKeyBuffer);

        try {
            DecryptResult result = kmsClient.decrypt(req);

            // Check that the key ids match, otherwise this should not be allowed.
            // Technically not required, but the HSM version will require the keyId
            //String decryptedKeyId = result.getKeyId();
            //if(dataKeyEncryptionKeyId != kmsClient.decrypt(req).getKeyId())
            //    return null;

            // Lame, but it will do for now
            byte[] iv = new byte[IV_SIZE];
            SecureRandom.getInstanceStrong().nextBytes(iv);

            return new DecryptDataKeyResponse(
                    result.getKeyId(),
                    encoder.encodeToString(iv),
                    encoder.encodeToString(result.getPlaintext().array())
            );
        } catch(Exception ex) {
            throw new DataKeyDecryptionFailure();
        }
    }
}
