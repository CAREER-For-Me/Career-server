package Career.server.web.dto.response;

import Career.server.domain.enums.Major;
import Career.server.domain.mapping.Passed;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class PassedResponseDto {

    private Major major;

    private Double avgGrade;

    private Integer toeicScore;

    private Integer tosLevel;

    private Integer certificationCount;

    private Integer extActivities;

    private Integer awardCount;

    private Integer internCount;

    public PassedResponseDto(Passed passed) {
        this.major = passed.getMajor();
        this.avgGrade = passed.getAvgGrade();
        this.toeicScore = passed.getToeicScore();
        this.tosLevel = passed.getTosLevel();
        this.certificationCount = passed.getCertificationCount();
        this.extActivities = passed.getExtActivities();
        this.awardCount = passed.getAwardCount();
        this.internCount = passed.getInternCount();
    }
}
