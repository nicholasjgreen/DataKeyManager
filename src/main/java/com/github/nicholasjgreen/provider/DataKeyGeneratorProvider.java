package com.github.nicholasjgreen.provider;

import com.github.nicholasjgreen.dto.GenerateDataKeyResponse;

public interface DataKeyGeneratorProvider {
    GenerateDataKeyResponse generateDataKey(String keyId);
}
