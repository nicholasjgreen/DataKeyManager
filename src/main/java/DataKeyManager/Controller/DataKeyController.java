package DataKeyManager.Controller;

import DataKeyManager.DTO.DecryptDataKeyResult;
import DataKeyManager.DTO.GenerateDataKeyResult;
import DataKeyManager.Service.DataKeyService;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataKeyController {

    private DataKeyService dataKeyService = new DataKeyService();

    @RequestMapping(value="/datakey", method = RequestMethod.GET)
    public GenerateDataKeyResult Generate(){
        return dataKeyService.generate();
    }

    @RequestMapping(value="/datakey/actions/decrypt", method = RequestMethod.POST)
    public DecryptDataKeyResult Decrypt(@RequestParam(value="keyId") String dataKeyEncryptionKeyId, @RequestBody String ciphertextDataKey) {
        return dataKeyService.decrypt(dataKeyEncryptionKeyId, ciphertextDataKey);
    }
}
