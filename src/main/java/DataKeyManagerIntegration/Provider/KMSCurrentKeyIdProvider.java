package DataKeyManagerIntegration.Provider;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.KeyListEntry;
import com.amazonaws.services.kms.model.ListKeysRequest;

import java.util.List;

public class KMSCurrentKeyIdProvider {

    public String getKeyId() {
        return this.listKeys(1).get(0).getKeyId();
    }

    private AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();

    List<KeyListEntry> listKeys(int limit){
        ListKeysRequest req = new ListKeysRequest().withLimit(limit);
        return kmsClient.listKeys(req).getKeys();
    }
}
