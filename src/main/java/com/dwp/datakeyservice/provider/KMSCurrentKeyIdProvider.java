package com.dwp.datakeyservice.provider;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.KeyListEntry;
import com.amazonaws.services.kms.model.ListKeysRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KMSCurrentKeyIdProvider implements CurrentKeyIdProvider {

    private AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();

    public String getKeyId() {
        return this.listKeys(1).get(0).getKeyId();
    }

    List<KeyListEntry> listKeys(int limit) {
        ListKeysRequest req = new ListKeysRequest().withLimit(limit);
        return kmsClient.listKeys(req).getKeys();
    }
}
