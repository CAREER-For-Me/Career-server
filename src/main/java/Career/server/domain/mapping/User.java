package Career.server.domain.mapping;

import Career.server.domain.common.BaseEntity;
import Career.server.domain.enums.Gender;
import Career.server.domain.enums.UserRole;
import Career.server.domain.enums.UserStatus;
import Career.server.web.dto.request.SignUpReqDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Builder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;

    private String nickname;

    private String username;

    private String password;

    private String birth;

    private String phoneNum;

    private String type;

    private String role;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private UserStatus userstatus;

    private LocalDateTime inactivedAt;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    public User(SignUpReqDto dto) {
        this.password = dto.getPassword();
        this.email = dto.getEmail();
        this.type = "NotYet";
        this.role = "ROLE_USER";
    }

    public User(String email, String type) {
        this.password = "NotYet";
        this.email = email;
        this.type = type;
        this.role = "ROLE_USER";
    }

    public User updatePassword(String newPassword) {
        this.password = newPassword;
        return this;
    }

}
