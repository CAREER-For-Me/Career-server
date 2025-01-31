package Career.server.web.controller;

import Career.server.apiPayload.ApiResponse;
import Career.server.service.AuthService;
import Career.server.web.dto.request.*;
import Career.server.web.dto.response.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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
    public ApiResponse<?> passwordChange(
            @RequestBody @Valid EmailCertificationReqDto request
    ) {
        ApiResponse<?> response = authService.passwordCertification(request);
        log.debug(" emailCertification's request: " + request + "emailCertification's response: " + response);
        return response;
    }


    @PostMapping("/signup")
    public ApiResponse<?> signUp(
            @RequestBody @Valid SignUpReqDto request
    ) {
        ApiResponse<?> response = authService.signUp(request);
        log.debug(" signUp's request: " + request + "signUp's response: " + response);
        return response;
    }

    @PostMapping("/login")
    public ApiResponse<?> logIn(
            @RequestBody @Valid LoginReqDto request
    ) {
        ApiResponse<?> response = authService.login(request);
        log.debug(" logIn's request: " + request + "logIn's response: " + response);
        return response;
    }
}