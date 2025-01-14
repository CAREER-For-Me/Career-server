package Career.server.web.dto.request.auth;

import Career.server.apiPayload.code.status.ResponseCode;
import Career.server.apiPayload.code.status.ResponseMessage;
import Career.server.web.dto.response.BaseResponseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@NoArgsConstructor
public class LoginReqDto {

    @NotBlank
    private String id;

    @NotBlank
    private String password;

}


