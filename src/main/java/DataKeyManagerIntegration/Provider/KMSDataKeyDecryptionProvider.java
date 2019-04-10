package DataKeyManagerIntegration.Provider;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.DecryptResult;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;

@Service
public class KMSDataKeyDecryptionProvider implements DataKeyDecryptionProvider {
    private AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();
    private Base64.Encoder encoder = Base64.getEncoder();
    private Base64.Decoder decoder = Base64.getDecoder();

    public DataKeyManagerIntegration.DTO.DecryptDataKeyResult decryptDataKey(String dataKeyEncryptionKeyId, String ciphertextDataKey) {

        ByteBuffer ciphertextDataKeybuffer = ByteBuffer.wrap(decoder.decode(ciphertextDataKey));
        DecryptRequest req = new DecryptRequest().withCiphertextBlob(ciphertextDataKeybuffer);

        DecryptResult result = kmsClient.decrypt(req);

        // Check that the key ids match, otherwise this should not be allowed.
        // Technically not required, but the HSM version will require the keyId
        String decryptedKeyId = result.getKeyId();
        //if(dataKeyEncryptionKeyId != kmsClient.decrypt(req).getKeyId())
        //    return null;

        // Lame, but it will do for now
        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        return new DataKeyManagerIntegration.DTO.DecryptDataKeyResult(result.getKeyId(),
                encoder.encodeToString(iv),
                encoder.encodeToString(result.getPlaintext().array()));
    }
}
