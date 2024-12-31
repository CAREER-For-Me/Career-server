package Career.server.domain.mapping;

import Career.server.domain.common.BaseEntity;
import Career.server.domain.enums.CorporateType;
import Career.server.domain.enums.PostingGubun;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Posting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PostingGubun postingGubun;

    private String title;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private CorporateType corporateType;

    private String target;

    private LocalDate startDate;

    private LocalDate endDate;

    private String homepageUrl;

    private String area;

    private String salary;

    private String position;

    private String content;

}
