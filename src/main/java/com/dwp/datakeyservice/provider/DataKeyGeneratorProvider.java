package com.dwp.datakeyservice.provider;

import com.dwp.datakeyservice.dto.GenerateDataKeyResult;

public interface DataKeyGeneratorProvider {
    GenerateDataKeyResult generateDataKey(String keyId);
}
