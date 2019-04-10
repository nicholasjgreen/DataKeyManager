package DataKeyManagerIntegration.Provider;

public interface DataKeyDecryptionProvider {
    DataKeyManagerIntegration.DTO.DecryptDataKeyResult decryptDataKey(String dataKeyEncryptionKeyId, String ciphertextDataKey);
}
