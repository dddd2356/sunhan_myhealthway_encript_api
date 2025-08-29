package myhealthway.myhealthway_encrypt.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EncryptionRequest {
    @NotBlank(message = "주민번호는 필수입니다.")
    @Pattern(regexp = "^\\d{6}-?\\d{7}$", message = "올바른 주민번호 형식이 아닙니다.")
    private String residentNumber;

    @NotBlank(message = "SEED 키는 필수입니다.")
    private String seedKey;
}
