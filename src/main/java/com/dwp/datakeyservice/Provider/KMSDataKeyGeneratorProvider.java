package com.dwp.datakeyservice.Provider;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.*;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class KMSDataKeyGeneratorProvider implements DataKeyGeneratorProvider {
    private AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();
    private Base64.Encoder encoder = Base64.getEncoder();

    public com.dwp.datakeyservice.DTO.GenerateDataKeyResult generateDataKey(String keyId) {
        GenerateDataKeyRequest dataKeyRequest = new GenerateDataKeyRequest();
        dataKeyRequest.setKeyId(keyId);
        dataKeyRequest.setKeySpec("AES_128");

        try {
            GenerateDataKeyResult result = kmsClient.generateDataKey(dataKeyRequest);
            return new com.dwp.datakeyservice.DTO.GenerateDataKeyResult(result.getKeyId(),
                    encoder.encodeToString(result.getPlaintext().array()),
                    encoder.encodeToString(result.getCiphertextBlob().array()));
        }
        catch(NotFoundException | DisabledException | KeyUnavailableException | DependencyTimeoutException |
                InvalidKeyUsageException | InvalidGrantTokenException | KMSInternalException | KMSInvalidStateException ex){
            // TODO: logging goes here
            return null;
        }
    }
}
