package com.github.nicholasjgreen.controller;

import com.github.nicholasjgreen.dto.DecryptDataKeyResponse;
import com.github.nicholasjgreen.dto.GenerateDataKeyResponse;
import com.github.nicholasjgreen.service.DataKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataKeyController {

    private DataKeyService dataKeyService;

    @Autowired
    public DataKeyController(DataKeyService dataKeyService) {
        this.dataKeyService = dataKeyService;
    }

    @RequestMapping(value = "/datakey", method = RequestMethod.GET)
    public GenerateDataKeyResponse generate() {
        return dataKeyService.generate();
    }

    @RequestMapping(value = "/datakey/actions/decrypt", method = RequestMethod.POST)
    public DecryptDataKeyResponse decrypt(
            @RequestParam(value = "keyId") String dataKeyEncryptionKeyId,
            @RequestBody String ciphertextDataKey
    ) {
        return dataKeyService.decrypt(dataKeyEncryptionKeyId, ciphertextDataKey);
    }
}
