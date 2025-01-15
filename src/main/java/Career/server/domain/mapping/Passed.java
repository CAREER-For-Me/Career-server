package Career.server.domain.mapping;

import Career.server.domain.common.BaseEntity;
import Career.server.domain.enums.Major;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Passed extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passed_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private Major major;

    private Double avgGrade;

    private Integer toeicScore;

    private Integer tosLevel;

    private Integer certificationCount;

    private Integer extActivities;

    private Integer awardCount;

    private Integer InternCount;
}
