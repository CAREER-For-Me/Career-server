package Career.server.web.dto.response.auth;

import Career.server.apiPayload.code.status.ResponseCode;
import Career.server.apiPayload.code.status.ResponseMessage;
import Career.server.web.dto.request.auth.LoginReqDto;
import Career.server.web.dto.response.BaseResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class LoginResDto extends BaseResponseDto{

    private String token;
    private  int expirationTime;

    private LoginResDto(String token) {
        super();
        this.token = token;
        this.expirationTime = 3600;
    }

    public static ResponseEntity<LoginResDto> success(String token) {
        LoginResDto responseBody = new LoginResDto(token);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<BaseResponseDto> signInFail(String token) {
        BaseResponseDto responseBody = new BaseResponseDto(ResponseCode.SIGN_IN_FAIL, ResponseMessage.SIGN_IN_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
}
