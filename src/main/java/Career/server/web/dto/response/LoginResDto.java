package Career.server.web.dto.response;


import lombok.Getter;

@Getter
public class LoginResDto{

    private String token;
    private  int expirationTime;

    private LoginResDto(String token) {
        super();
        this.token = token;
        this.expirationTime = 3600;
    }

}
