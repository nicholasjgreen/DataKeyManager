package com.github.nicholasjgreen.provider;

import com.github.nicholasjgreen.dto.DecryptDataKeyResponse;

public interface DataKeyDecryptionProvider {
    DecryptDataKeyResponse decryptDataKey(String dataKeyEncryptionKeyId, String ciphertextDataKey);
}
