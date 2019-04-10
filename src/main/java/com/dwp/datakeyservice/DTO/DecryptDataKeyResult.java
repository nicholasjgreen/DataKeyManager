package com.dwp.datakeyservice.DTO;

@SuppressWarnings({"unused", "WeakerAccess"})
public class DecryptDataKeyResult {
    public DecryptDataKeyResult() {
    }

    public DecryptDataKeyResult(String dataKeyEncryptionKeyId, String iv, String plaintextDataKey) {
        this.dataKeyEncryptionKeyId = dataKeyEncryptionKeyId;
        this.iv = iv;
        this.plaintextDataKey = plaintextDataKey;
    }


    public String dataKeyEncryptionKeyId;
    public String iv;
    public String plaintextDataKey;
}
