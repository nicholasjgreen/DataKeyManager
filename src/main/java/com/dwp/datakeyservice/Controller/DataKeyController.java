package com.dwp.datakeyservice.Controller;

import com.dwp.datakeyservice.DTO.DecryptDataKeyResult;
import com.dwp.datakeyservice.DTO.GenerateDataKeyResult;
import com.dwp.datakeyservice.Service.DataKeyService;
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
    public GenerateDataKeyResult Generate(){
        return dataKeyService.generate();
    }

    @RequestMapping(value="/datakey/actions/decrypt", method = RequestMethod.POST)
    public DecryptDataKeyResult Decrypt(@RequestParam(value="keyId") String dataKeyEncryptionKeyId, @RequestBody String ciphertextDataKey) {
        return dataKeyService.decrypt(dataKeyEncryptionKeyId, ciphertextDataKey);
    }
}
