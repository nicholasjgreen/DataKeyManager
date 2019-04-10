package com.dwp.datakeyservice.Provider;

public interface DataKeyGeneratorProvider {
    com.dwp.datakeyservice.DTO.GenerateDataKeyResult generateDataKey(String keyId);
}
