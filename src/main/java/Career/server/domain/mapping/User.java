package Career.server.domain.mapping;

import Career.server.web.dto.request.auth.SignUpReqDto;
import jakarta.persistence.*;
import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    private String userId;
    private String password;
    private String email;
    // 로그인 시 네이버, 카카오, 메일 중 하나
    private String type;
    private String role;

    public User(SignUpReqDto dto) {
        this.userId = dto.getId();
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.type = "NotYet";
        this.role = "ROLE_USER";
    }

    public User(String userId, String email, String type) {
        this.userId = userId;
        this.password = "NotYet";
        this.email = email;
        this.type = type;
        this.role = "ROLE_USER";
    }

}
