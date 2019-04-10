package com.dwp.datakeyservice.service;

import com.dwp.datakeyservice.dto.DecryptDataKeyResponse;
import com.dwp.datakeyservice.dto.GenerateDataKeyResponse;
import com.dwp.datakeyservice.provider.CurrentKeyIdProvider;
import com.dwp.datakeyservice.provider.DataKeyDecryptionProvider;
import com.dwp.datakeyservice.provider.DataKeyGeneratorProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataKeyService {
    private DataKeyGeneratorProvider dataKeyProvider;
    private CurrentKeyIdProvider currentKeyIdProvider;
    private DataKeyDecryptionProvider dataKeyDecryptionProvider;

    @Autowired
    public DataKeyService(
            DataKeyGeneratorProvider dataKeyProvider,
            CurrentKeyIdProvider currentKeyIdProvider,
            DataKeyDecryptionProvider dataKeyDecryptionProvider
    ) {
        this.dataKeyProvider = dataKeyProvider;
        this.currentKeyIdProvider = currentKeyIdProvider;
        this.dataKeyDecryptionProvider = dataKeyDecryptionProvider;
    }

    public GenerateDataKeyResponse generate() {
        String keyEncryptionKeyId = currentKeyIdProvider.getKeyId();
        return dataKeyProvider.generateDataKey(keyEncryptionKeyId);
    }

    public DecryptDataKeyResponse decrypt(String dataKeyEncryptionKeyId, String ciphertextDataKey) {
        return dataKeyDecryptionProvider.decryptDataKey(dataKeyEncryptionKeyId, ciphertextDataKey);
    }
}
