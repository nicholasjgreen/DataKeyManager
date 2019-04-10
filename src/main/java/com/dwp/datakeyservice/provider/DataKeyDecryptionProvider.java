package com.dwp.datakeyservice.provider;

import com.dwp.datakeyservice.dto.DecryptDataKeyResult;

public interface DataKeyDecryptionProvider {
    DecryptDataKeyResult decryptDataKey(String dataKeyEncryptionKeyId, String ciphertextDataKey);
}
