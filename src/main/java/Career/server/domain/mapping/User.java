package Career.server.domain.mapping;

import Career.server.domain.common.BaseEntity;
import Career.server.domain.enums.Gender;
import Career.server.domain.enums.UserRole;
import Career.server.domain.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nickname;

    private String username;

    private String password;

    private String phoneNum;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private UserStatus userstatus;

    private LocalDateTime inactivedAt;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
