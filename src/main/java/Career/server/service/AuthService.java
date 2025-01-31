package Career.server.service;

import Career.server.apiPayload.ApiResponse;
import Career.server.apiPayload.code.BaseCode;
import Career.server.web.dto.request.*;
import Career.server.web.dto.response.*;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ApiResponse<?> passwordCertification(EmailCertificationReqDto dto);
    ApiResponse<?> signUp(SignUpReqDto dto);

    ApiResponse<?> login(LoginReqDto dto);
}
