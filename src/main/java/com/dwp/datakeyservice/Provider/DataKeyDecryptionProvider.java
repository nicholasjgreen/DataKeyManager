package com.dwp.datakeyservice.Provider;

public interface DataKeyDecryptionProvider {
    com.dwp.datakeyservice.DTO.DecryptDataKeyResult decryptDataKey(String dataKeyEncryptionKeyId, String ciphertextDataKey);
}
