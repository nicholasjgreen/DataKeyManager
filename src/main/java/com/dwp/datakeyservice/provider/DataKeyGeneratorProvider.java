package com.dwp.datakeyservice.provider;

import com.dwp.datakeyservice.dto.GenerateDataKeyResponse;

public interface DataKeyGeneratorProvider {
    GenerateDataKeyResponse generateDataKey(String keyId);
}
