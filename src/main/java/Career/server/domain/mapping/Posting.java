package Career.server.domain.mapping;

import Career.server.domain.common.BaseEntity;
import Career.server.domain.enums.CorporateType;
import Career.server.domain.enums.PostingGubun;
import Career.server.domain.enums.PostingStatus;
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

    @Enumerated(EnumType.ORDINAL)
    private PostingGubun postingGubun;

    @Enumerated(EnumType.STRING)
    private PostingStatus postingStatus;

    private String title;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private CorporateType corporateType;


    private LocalDate startDate;

    private LocalDate endDate;

    private String homepageUrl;

    private LocalDate startAct;

    private LocalDate endAct;

    private String area;

    private String salary;

    private String related;

    @Builder.Default
    private Integer views = 0;

    private String content;

    private Boolean mark;

    public void incrementViews(){
        this.views++;
    }

}
