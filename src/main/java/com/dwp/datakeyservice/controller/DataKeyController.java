package com.dwp.datakeyservice.controller;

import com.dwp.datakeyservice.dto.DecryptDataKeyResponse;
import com.dwp.datakeyservice.dto.GenerateDataKeyResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataKeyController {

    @RequestMapping(value = "/datakey", method = RequestMethod.GET)
    public GenerateDataKeyResponse generate() {
        return new GenerateDataKeyResponse();
    }

    @RequestMapping(value = "/datakey/actions/decrypt", method = RequestMethod.POST)
    public DecryptDataKeyResponse decrypt(
            @RequestParam(value = "keyId") String dataKeyEncryptionKeyId,
            @RequestBody String ciphertextDataKey
    ) {
        return new DecryptDataKeyResponse();
    }
}
