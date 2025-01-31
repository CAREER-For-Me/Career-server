package Career.server.web.dto.request;

import Career.server.domain.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpReqDto {

    @NotBlank
    @Email
    private String email;

    // Password only can be 8-13 characters long, contains alphanumeric characters.
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,20}$")
    private String password;

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{8}", message = "생일은 yyyyMMdd 형식이어야 합니다.")
    private String birth;

    @NotBlank
    private String phoneNum;

    @NotNull(message = "Gender must not be null and only can be MALE or FEMALE")
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
