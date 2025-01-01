package Career.server.web.dto;


import lombok.Builder;

import java.time.LocalDate;

public class PostingDto {

    // 공고 상세조회
    @Builder
    public static class DetailResponseDto{
        private String title;
        private String corporateType;
        private LocalDate startAct;
        private LocalDate endAct;
        private LocalDate startDate;
        private LocalDate endDate;
        private String area;
        private String related;
        private String salary;
        private String homepageUrl;
        private String imageUrl;
        private String content;
    }

}
