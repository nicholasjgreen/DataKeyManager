package DataKeyManager.Service;

import DataKeyManager.DTO.DecryptDataKeyResult;
import DataKeyManager.DTO.GenerateDataKeyResult;
import DataKeyManager.Provider.KMSCurrentKeyIdProvider;
import DataKeyManager.Provider.KMSDataKeyDecryptionProvider;
import DataKeyManager.Provider.KMSDataKeyGeneratorProvider;

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
