package com.dwp.datakeyservice.provider;

import com.dwp.datakeyservice.dto.DecryptDataKeyResponse;

public interface DataKeyDecryptionProvider {
    DecryptDataKeyResponse decryptDataKey(String dataKeyEncryptionKeyId, String ciphertextDataKey);
}
