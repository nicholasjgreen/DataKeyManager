package com.dwp.datakeyservice.DTO;

@SuppressWarnings({"unused", "WeakerAccess"})
public class GenerateDataKeyResult {
    public String dataKeyEncryptionKeyId;
    public String plaintextDataKey;
    public String ciphertextDataKey;

    public GenerateDataKeyResult(){
    }

    public GenerateDataKeyResult(String dataKeyEncryptionKeyId, String plaintextDataKey, String ciphertextDataKey){
        this.dataKeyEncryptionKeyId = dataKeyEncryptionKeyId;
        this.plaintextDataKey = plaintextDataKey;
        this.ciphertextDataKey = ciphertextDataKey;
    }
}
