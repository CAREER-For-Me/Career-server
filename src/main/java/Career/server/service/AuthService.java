package Career.server.service;

import Career.server.web.dto.request.auth.*;
import Career.server.web.dto.response.auth.*;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<? super EmailCertificationResDto> emailCertification(EmailCertificationReqDto dto);
    ResponseEntity<? super CheckCertificationResDto> checkCertification(CheckCertificationReqDto dto);
    ResponseEntity<? super IdCheckResDto> idCheck(IdCheckReqDto dto);
    ResponseEntity<? super SignUpResDto> signUp(SignUpReqDto dto);
    ResponseEntity<? super LoginResDto> login(LoginReqDto dto);

}
