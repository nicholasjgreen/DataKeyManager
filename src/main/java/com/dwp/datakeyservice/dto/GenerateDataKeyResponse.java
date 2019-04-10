package com.dwp.datakeyservice.dto;

@SuppressWarnings({"unused", "WeakerAccess"})
public class GenerateDataKeyResponse {
    public String dataKeyEncryptionKeyId;
    public String plaintextDataKey;
    public String ciphertextDataKey;

    public GenerateDataKeyResponse(){
    }

    public GenerateDataKeyResponse(String dataKeyEncryptionKeyId, String plaintextDataKey, String ciphertextDataKey){
        this.dataKeyEncryptionKeyId = dataKeyEncryptionKeyId;
        this.plaintextDataKey = plaintextDataKey;
        this.ciphertextDataKey = ciphertextDataKey;
    }
}
