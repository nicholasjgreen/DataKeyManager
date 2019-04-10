package com.dwp.datakeyservice.dto;

@SuppressWarnings({"unused", "WeakerAccess"})
public class DecryptDataKeyResponse {
    public DecryptDataKeyResponse() {
    }

    public DecryptDataKeyResponse(String dataKeyEncryptionKeyId, String iv, String plaintextDataKey) {
        this.dataKeyEncryptionKeyId = dataKeyEncryptionKeyId;
        this.iv = iv;
        this.plaintextDataKey = plaintextDataKey;
    }


    public String dataKeyEncryptionKeyId;
    public String iv;
    public String plaintextDataKey;
}
