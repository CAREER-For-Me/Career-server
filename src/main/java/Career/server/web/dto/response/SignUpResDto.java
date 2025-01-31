package Career.server.web.dto.response;


import Career.server.domain.enums.Gender;
import lombok.Getter;

@Getter
public class SignUpResDto{
    String email;
    String password;
    String name;
    String birth;
    Gender gender;
    String phoneNum;

}
