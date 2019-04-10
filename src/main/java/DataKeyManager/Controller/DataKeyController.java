package DataKeyManager.Controller;

import DataKeyManager.DTO.DecryptDataKeyResponse;
import DataKeyManager.DTO.GenerateDataKeyResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class DataKeyController {

    @RequestMapping(value="/datakey", method = RequestMethod.GET)
    public GenerateDataKeyResponse Generate(){
        return new GenerateDataKeyResponse();
    }

    @RequestMapping(value="/datakey/actions/decrypt", method = RequestMethod.POST)
    public DecryptDataKeyResponse Decrypt(@RequestParam(value="keyId") String datakeyEncryptionKeyId, @RequestBody String ciphertextDatakey) {
        return new DecryptDataKeyResponse();
    }
}
