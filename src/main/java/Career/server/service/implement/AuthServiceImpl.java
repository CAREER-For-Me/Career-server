package Career.server.service.implement;


import Career.server.apiPayload.ApiResponse;
import Career.server.apiPayload.code.BaseCode;
import Career.server.apiPayload.code.status.ErrorStatus;
import Career.server.apiPayload.code.status.SuccessStatus;
import Career.server.apiPayload.handler.AuthHandler;
import Career.server.apiPayload.handler.CertificationNumber;
import Career.server.converter.auth.UserConverter;
import Career.server.domain.mapping.Certification;
import Career.server.domain.mapping.User;
import Career.server.provider.EmailProvider;
import Career.server.provider.JwtProvider;
import Career.server.repository.CertificationRepository;
import Career.server.repository.UserRepository;
import Career.server.service.AuthService;
import Career.server.web.dto.request.*;
import Career.server.web.dto.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final CertificationRepository certificationRepository;
    private final EmailProvider emailProvider;
    private final JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ApiResponse<?> passwordCertification(EmailCertificationReqDto dto) {

        try {
            User user = userRepository.findByEmail(dto.getEmail());

            boolean isExistEmail = userRepository.existsByEmail(user.getEmail());
            if(!isExistEmail) return ApiResponse.onFailure(ErrorStatus._NON_EXIST_EMAIL.getCode(), ErrorStatus._NON_EXIST_EMAIL.getMessage(), dto);

            String certificationNumber = CertificationNumber.getCertificationNumber();

            boolean isSuccess =emailProvider.sendCertificationMail(user.getEmail(), certificationNumber);
            if(!isSuccess) return ApiResponse.onFailure(ErrorStatus._MAILSENDER_ERROR.getCode(), ErrorStatus._MAILSENDER_ERROR.getMessage(), "다시 해 보시오");

            String encodedPassword = passwordEncoder.encode(certificationNumber);
            user.updatePassword(encodedPassword);
            userRepository.save(user);


        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.onFailure(ErrorStatus._INTERNAL_SERVER_ERROR.getCode(),ErrorStatus._INTERNAL_SERVER_ERROR.getMessage(), dto);
        }

        return ApiResponse.onSuccess(SuccessStatus._OK);
    }



    @Override
    public ApiResponse<?> signUp(SignUpReqDto dto){
        try {

            boolean isExistEmail = userRepository.existsByEmail(dto.getEmail());
            if(isExistEmail) return ApiResponse.onFailure(ErrorStatus._DUPLICATED_EMAIL.getCode(), ErrorStatus._DUPLICATED_EMAIL.getMessage(), dto);

            String encodedPassword = passwordEncoder.encode(dto.getPassword());
            dto.setPassword(encodedPassword);

            User user = UserConverter.signUpConverter(dto);

            userRepository.save(user);


        } catch (Exception e) {
            e.printStackTrace();
            return ApiResponse.onFailure(ErrorStatus._INTERNAL_SERVER_ERROR.getCode(),ErrorStatus._INTERNAL_SERVER_ERROR.getMessage(), dto);
        }

        return ApiResponse.onSuccess(SuccessStatus._OK);
    }

    @Override
    public ApiResponse<?> login(LoginReqDto dto) {

        String token = null;
        try {
            String email = dto.getEmail();
            User user = userRepository.findByEmail(email);
            if(user == null) return ApiResponse.onFailure(ErrorStatus._NON_EXIST_EMAIL.getCode(),ErrorStatus._NON_EXIST_EMAIL.getMessage(),dto);


            String password = dto.getPassword();
            String encodedPassword = user.getPassword();
            boolean isCorrect = passwordEncoder.matches(password, encodedPassword);
            if(!isCorrect) return ApiResponse.onFailure(ErrorStatus._BAD_PASSWORD.getCode(), ErrorStatus._BAD_PASSWORD.getMessage(), token);

            token = jwtProvider.create(String.valueOf(user.getId()));

        } catch (Exception e){
            e.printStackTrace();
            return ApiResponse.onFailure(ErrorStatus._INTERNAL_SERVER_ERROR.getCode(),ErrorStatus._INTERNAL_SERVER_ERROR.getMessage(), dto);
        }
        System.out.println(token);
        return ApiResponse.onSuccess(SuccessStatus._OK);
    }


}
