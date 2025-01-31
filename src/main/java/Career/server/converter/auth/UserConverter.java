package Career.server.converter.auth;

import Career.server.domain.mapping.User;
import Career.server.repository.UserRepository;
import Career.server.web.dto.request.SignUpReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final UserRepository userRepository;

    public static User signUpConverter(SignUpReqDto request) {
        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .username(request.getName())
                .birth(request.getBirth())
                .phoneNum(request.getPhoneNum())
                .gender(request.getGender())
                .build();

        return user;
    }
}
