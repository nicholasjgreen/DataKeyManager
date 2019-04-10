package com.dwp.datakeyservice.controller;

import com.amazonaws.services.kms.model.GenerateDataKeyResult;
import com.dwp.datakeyservice.dto.DecryptDataKeyResponse;
import com.dwp.datakeyservice.dto.GenerateDataKeyResponse;
import com.dwp.datakeyservice.service.DataKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataKeyController {

    @Autowired
    public DataKeyController(DataKeyService dataKeyService) {
        this.dataKeyService = dataKeyService;
    }

    private DataKeyService dataKeyService;

    @RequestMapping(value="/datakey", method = RequestMethod.GET)
    public GenerateDataKeyResponse generate(){
        return dataKeyService.generate();
    }

    @RequestMapping(value="/datakey/actions/decrypt", method = RequestMethod.POST)
    public DecryptDataKeyResponse decrypt(@RequestParam(value="keyId") String dataKeyEncryptionKeyId, @RequestBody String ciphertextDataKey) {
        return dataKeyService.decrypt(dataKeyEncryptionKeyId, ciphertextDataKey);
    }
}
