package com.github.nicholasjgreen.provider;

import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.KeyListEntry;
import com.amazonaws.services.kms.model.ListKeysRequest;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterResult;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersResult;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("KMS")
public class KMSCurrentKeyIdProvider implements CurrentKeyIdProvider {

    private AWSKMS kmsClient = AWSKMSClientBuilder.defaultClient();

    /*
    {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "VisualEditor0",
            "Effect": "Allow",
            "Action": "ssm:GetParameter",
            "Resource": "arn:aws:ssm:REGION_HERE:ACCOUNT_ID:parameter/DataKeyManager.currentKeyId"
        }
    ]
}
     */


    public String getKeyId() {
        AWSSimpleSystemsManagement client= AWSSimpleSystemsManagementClientBuilder.defaultClient();
        GetParameterRequest request = new GetParameterRequest()
            .withName("DataKeyManager.currentKeyId")
            .withWithDecryption(false);
        GetParameterResult result = client.getParameter(request);
        return result.getParameter().getValue();
    }

    private List<KeyListEntry> listKeys(int limit) {
        ListKeysRequest req = new ListKeysRequest().withLimit(limit);
        return kmsClient.listKeys(req).getKeys();
    }
}
