package myhealthway.myhealthway_encrypt.Controller;


import jakarta.validation.Valid;
import myhealthway.myhealthway_encrypt.Dto.EncryptionRequest;
import myhealthway.myhealthway_encrypt.Service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/encryption")
public class EncryptionController {
    private final EncryptionService encryptionService;

    @Autowired
    public EncryptionController(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    /**
     * 주민번호 SEED 암호화 API
     *
     * @param request 암호화 요청 정보
     * @param bindingResult 유효성 검사 결과
     * @return ResponseEntity<EncryptionResponse> 암호화 결과
     */
    @PostMapping("/resident-number")
    public ResponseEntity<String> encryptResidentNumber(
            @Valid @RequestBody EncryptionRequest request,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("유효하지 않은 입력값입니다.");
        }
        try {
            String encrypted = encryptionService.encryptResidentNumber(request);
            return ResponseEntity.ok(encrypted);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("암호화 실패");
        }
    }
}
