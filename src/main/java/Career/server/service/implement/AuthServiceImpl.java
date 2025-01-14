package Career.server.service.implement;


import Career.server.apiPayload.authcode.CertificationNumber;
import Career.server.domain.mapping.Certification;
import Career.server.domain.mapping.User;
import Career.server.provider.EmailProvider;
import Career.server.provider.JwtProvider;
import Career.server.repository.CertificationRepository;
import Career.server.repository.UserRepository;
import Career.server.service.AuthService;
import Career.server.web.dto.BaseResponseDto;
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
    public ResponseEntity<? super EmailCertificationResDto> emailCertification(EmailCertificationReqDto dto) {

        try {
            String userId = dto.getId();
            String email = dto.getEmail();

            boolean isExistId = userRepository.existsByMemberId(userId);
            if(isExistId) return EmailCertificationResDto.duplicateEmail();

            String certificationNumber = CertificationNumber.getCertificationNumber();

            boolean isSuccess =emailProvider.sendCertificationMail(email, certificationNumber);
            if(!isSuccess) return EmailCertificationResDto.mailSendFail();

            Certification certification = new Certification(userId, email, certificationNumber);
            certificationRepository.save(certification);

        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponseDto.databaseError();
        }

        return EmailCertificationResDto.success();
    }

    @Override
    public ResponseEntity<? super CheckCertificationResDto> checkCertification(CheckCertificationReqDto dto) {

        try {

            String userId = dto.getId();
            String email = dto.getEmail();
            String certificationNumber = dto.getCertificationNumber();

            Certification cert = certificationRepository.findByUserId(userId);
            if(cert == null) return CheckCertificationResDto.certificationFail();

            boolean isCorrect = cert.getEmail().equals(email)&&cert.getCertificationNumber().equals(certificationNumber);
            if(!isCorrect) return CheckCertificationResDto.certificationFail();

        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponseDto.databaseError();
        }

        return CheckCertificationResDto.success();
    }

    @Override
    public ResponseEntity<? super IdCheckResDto> idCheck(IdCheckReqDto dto) {

        try {

            String userId = dto.getId();
            boolean isExistId = userRepository.existsByMemberId(userId);
            if(isExistId) return IdCheckResDto.duplicateId();


        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponseDto.databaseError();
        }

        return IdCheckResDto.success();
    }

    @Override
    public ResponseEntity<? super SignUpResDto> signUp(SignUpReqDto dto) {

        try {

            String userId = dto.getId();
            boolean isExistId = userRepository.existsByMemberId(userId);
            if(isExistId) return SignUpResDto.duplicateId();

            String email = dto.getEmail();
            boolean isExistEmail = userRepository.existsByEmail(email);
            if(isExistEmail) return SignUpResDto.duplicateId();

            String certificationNum = dto.getCertificationNumber();

            Certification cert = certificationRepository.findByUserId(userId);
            boolean isCorrect = cert.getEmail().equals(email)&&cert.getCertificationNumber().equals(certificationNum);
            if(!isCorrect) return SignUpResDto.certificationFail();

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            User user = new User(dto);
            userRepository.save(user);

            certificationRepository.deleteByUserId(userId);

        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponseDto.databaseError();
        }

        return SignUpResDto.success();
    }

    @Override
    public ResponseEntity<? super LoginResDto> login(LoginReqDto dto) {

        String token = null;
        try {
            String userId = dto.getId();
            User user = userRepository.findByMemberId(userId);
            if(user == null) return LoginResDto.signInFail(token);

            String password = dto.getPassword();
            String encodedPassword = user.getPassword();
            boolean isCorrect = passwordEncoder.matches(password, encodedPassword);
            if(!isCorrect) return LoginResDto.signInFail(token);

            token = jwtProvider.create(userId);

        } catch (Exception e) {
            e.printStackTrace();
            return BaseResponseDto.databaseError();
        }

        return LoginResDto.success(token);
    }
}
