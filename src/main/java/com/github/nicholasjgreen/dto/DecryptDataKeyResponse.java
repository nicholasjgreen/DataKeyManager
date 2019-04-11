package com.github.nicholasjgreen.dto;

@SuppressWarnings({"unused", "WeakerAccess"})
public class DecryptDataKeyResponse {
    public String dataKeyEncryptionKeyId;
    public String iv;
    public String plaintextDataKey;

    public DecryptDataKeyResponse() {
    }

    public DecryptDataKeyResponse(String dataKeyEncryptionKeyId, String iv, String plaintextDataKey) {
        this.dataKeyEncryptionKeyId = dataKeyEncryptionKeyId;
        this.iv = iv;
        this.plaintextDataKey = plaintextDataKey;
    }
}
