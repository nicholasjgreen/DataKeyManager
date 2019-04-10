package com.dwp.datakeyservice.provider;

import com.dwp.datakeyservice.dto.GenerateDataKeyResult;
import org.junit.Test;
import org.springframework.util.Assert;

public class KMSDataKeyGeneratorProviderTest {

    @Test
    public void canGenerateDataKey(){
        KMSCurrentKeyIdProvider keyIdProvider = new KMSCurrentKeyIdProvider();
        KMSDataKeyGeneratorProvider providerUnderTest = new KMSDataKeyGeneratorProvider();

        GenerateDataKeyResult result = providerUnderTest.generateDataKey(keyIdProvider.getKeyId());
        Assert.notNull(result, "Must return a result");
    }


    @Test
    public void canGenerateDataKeyFailure(){
        KMSDataKeyGeneratorProvider providerUnderTest = new KMSDataKeyGeneratorProvider();

        GenerateDataKeyResult result = providerUnderTest.generateDataKey("frederick no keys");
        Assert.isNull(result, "Must return a null");
    }


    /* Missing tests:
        - Service failure
        - keyId invalid/missing
        - disabled key

     */
}
