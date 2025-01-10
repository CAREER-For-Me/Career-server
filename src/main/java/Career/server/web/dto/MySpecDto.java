package Career.server.web.dto;

import lombok.Data;

@Data
public class MySpecDto {
    private Double majorScore;
    private Integer toeicScore;
    private String tosLevel;
    private Integer internCount;
    private Integer awardCount;
    private Integer qualCount;

    public MySpecDto(Double totalScore, Integer toeicScore, String tosLevel,
                     Integer internCount, Integer awardCount, Integer qualCount) {
        this.majorScore = totalScore;
        this.toeicScore = toeicScore;
        this.tosLevel = tosLevel;
        this.internCount = internCount;
        this.awardCount = awardCount;
        this.qualCount = qualCount;
    }
}
