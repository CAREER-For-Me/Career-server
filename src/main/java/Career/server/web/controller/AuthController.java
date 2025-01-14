package Career.server.web.controller;

import Career.server.service.AuthService;
import Career.server.web.dto.request.auth.*;
import Career.server.web.dto.response.auth.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping("/certification/email")
    public ResponseEntity<? super EmailCertificationResDto> emailCertification(
            @RequestBody @Valid EmailCertificationReqDto request
    ) {
        ResponseEntity<? super EmailCertificationResDto> response = authService.emailCertification(request);
        log.debug(" emailCertification's request: " + request + "emailCertification's response: " + response);
        return response;
    }

    @PostMapping("/certification/check")
    public ResponseEntity<? super CheckCertificationResDto> checkCertification (
            @RequestBody @Valid CheckCertificationReqDto request
            ) {
        ResponseEntity<? super CheckCertificationResDto> response = authService.checkCertification(request);
        log.debug(" checkCertification's request: " + request + "checkCertification's response: " + response);
        return response;
    }

    @PostMapping("/certification/id")
    public ResponseEntity<? super IdCheckResDto> checkId (
            @RequestBody @Valid IdCheckReqDto request
    ) {
        ResponseEntity<? super IdCheckResDto> response = authService.idCheck(request);
        log.debug(" checkId's request: " + request + "checkId's response: " + response);
        return response;
    }

    @PostMapping("/signup")
    public ResponseEntity<? super SignUpResDto> signUp(
            @RequestBody @Valid SignUpReqDto request
    ) {
        ResponseEntity<? super SignUpResDto> response = authService.signUp(request);
        log.debug(" signUp's request: " + request + "signUp's response: " + response);
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<? super LoginResDto> logIn(
            @RequestBody @Valid LoginReqDto request
    ) {
        ResponseEntity<? super LoginResDto> response = authService.login(request);
        log.debug(" logIn's request: " + request + "logIn's response: " + response);
        return response;
    }
}
