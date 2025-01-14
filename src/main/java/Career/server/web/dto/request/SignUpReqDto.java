package Career.server.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpReqDto {

    @NotBlank
    private String id;

    // Password only can be 8-13 characters long, contains alphanumeric characters.
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,13}$")
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String certificationNumber;
}
