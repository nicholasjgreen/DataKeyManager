package com.dwp.datakeyservice.service;

import com.dwp.datakeyservice.dto.DecryptDataKeyResult;
import com.dwp.datakeyservice.dto.GenerateDataKeyResult;
import com.dwp.datakeyservice.provider.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataKeyService {
    private DataKeyGeneratorProvider dataKeyProvider;
    private CurrentKeyIdProvider currentKeyIdProvider;
    private DataKeyDecryptionProvider dataKeyDecryptionProvider;

    @Autowired
    public DataKeyService(DataKeyGeneratorProvider dataKeyProvider, CurrentKeyIdProvider currentKeyIdProvider, DataKeyDecryptionProvider dataKeyDecryptionProvider) {
        this.dataKeyProvider = dataKeyProvider;
        this.currentKeyIdProvider = currentKeyIdProvider;
        this.dataKeyDecryptionProvider = dataKeyDecryptionProvider;
    }

    public GenerateDataKeyResult generate() {
        String keyEncryptionKeyId = currentKeyIdProvider.getKeyId();
        return dataKeyProvider.generateDataKey(keyEncryptionKeyId);
    }

    public DecryptDataKeyResult decrypt(String dataKeyEncryptionKeyId, String ciphertextDataKey) {
        return dataKeyDecryptionProvider.decryptDataKey(dataKeyEncryptionKeyId, ciphertextDataKey);
    }
}
