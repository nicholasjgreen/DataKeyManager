package DataKeyManagerIntegration.Service;

import DataKeyManagerIntegration.DTO.DecryptDataKeyResult;
import DataKeyManagerIntegration.DTO.GenerateDataKeyResult;
import DataKeyManagerIntegration.Provider.KMSCurrentKeyIdProvider;
import DataKeyManagerIntegration.Provider.KMSDataKeyDecryptionProvider;
import DataKeyManagerIntegration.Provider.KMSDataKeyGeneratorProvider;

public class DataKeyService {
    private KMSDataKeyGeneratorProvider dataKeyProvider = new KMSDataKeyGeneratorProvider();
    private KMSCurrentKeyIdProvider currentKeyIdProvider = new KMSCurrentKeyIdProvider();
    private KMSDataKeyDecryptionProvider dataKeyDecryptionProvider = new KMSDataKeyDecryptionProvider();

    public GenerateDataKeyResult generate() {
        String keyEncryptionKeyId = currentKeyIdProvider.getKeyId();
        return dataKeyProvider.generateDataKey(keyEncryptionKeyId);
    }

    public DecryptDataKeyResult decrypt(String dataKeyEncryptionKeyId, String ciphertextDataKey) {
        return dataKeyDecryptionProvider.decryptDataKey(dataKeyEncryptionKeyId, ciphertextDataKey);
    }
}
