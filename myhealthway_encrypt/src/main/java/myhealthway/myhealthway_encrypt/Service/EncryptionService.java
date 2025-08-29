package myhealthway.myhealthway_encrypt.Service;

import myhealthway.myhealthway_encrypt.Dto.EncryptionRequest;
import myhealthway.myhealthway_encrypt.Util.MymdSeedCtrUtil;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {
    /**
     * 주민번호를 SEED 암호화하는 메서드
     *
     * @param request 암호화 요청 정보 (주민번호, SEED 키)
     * @return EncryptionResponse 암호화 결과
     */
    public String encryptResidentNumber(EncryptionRequest request) {
        String cleanResidentNumber = request.getResidentNumber().replace("-", "");
        return MymdSeedCtrUtil.SEED_CTR_Encrypt(
                request.getSeedKey(),
                cleanResidentNumber
        );
    }
}