package DataKeyManager.Provider;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.*;

import java.nio.ByteBuffer;
import java.util.Base64;

public class KMSDataKeyGeneratorProvider {
    private AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();
    private Base64.Encoder encoder = Base64.getEncoder();

    ByteBuffer encryptDataKeyWithKey(String keyId, ByteBuffer plaintextDataKey) {
        EncryptRequest req = new EncryptRequest().withKeyId(keyId).withPlaintext(plaintextDataKey);
        return kmsClient.encrypt(req).getCiphertextBlob();
    }



    public DataKeyManager.DTO.GenerateDataKeyResult generateDataKey(String keyId) {
        GenerateDataKeyRequest dataKeyRequest = new GenerateDataKeyRequest();
        dataKeyRequest.setKeyId(keyId);
        dataKeyRequest.setKeySpec("AES_128");

        GenerateDataKeyResult result = kmsClient.generateDataKey(dataKeyRequest);
        return new DataKeyManager.DTO.GenerateDataKeyResult(result.getKeyId(),
                encoder.encodeToString(result.getPlaintext().array()),
                encoder.encodeToString(result.getCiphertextBlob().array()));
    }
}
