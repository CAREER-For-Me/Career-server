package Career.server.domain.mapping;

import Career.server.domain.common.BaseEntity;
import Career.server.domain.enums.EduGubun;
import Career.server.domain.enums.MajorGubun;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Edu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String univName;

    @Enumerated(value = EnumType.STRING)
    private EduGubun eduGubun;

    @Enumerated(value = EnumType.STRING)
    private MajorGubun majorGubun;

    private String major;

    private Double totalScore;

    private Double majorScore;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


}
