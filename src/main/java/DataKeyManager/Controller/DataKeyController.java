package DataKeyManager.Controller;

import DataKeyManager.DTO.DecryptDataKeyResponse;
import DataKeyManager.DTO.GenerateDataKeyResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataKeyController {

    @RequestMapping("/datakey")
    public GenerateDataKeyResponse Generate(){
        return null;
    }

    @RequestMapping("/datakey/actions/decrypt")
    public DecryptDataKeyResponse Decrypt(@RequestParam(value="keyId") String datakeyEncryptionKeyId {
        return null;
    }
}
