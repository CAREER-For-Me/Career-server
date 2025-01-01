package Career.server.web.dto;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

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

    @Builder
    public static class PreviewDto{
        private Long postingId;
        private String title;
        private String corporateType;
        private String imageUrl;
        private LocalDate endDate;
        private Integer views;
    }

    @Builder
    public static class MainResponseDto{
        private List<PreviewDto> previewDtoList;
    }

    @Getter
    public static class ActRequestDto{
        private List<Long> fieldIds;
        private Integer postingGubun;
        private Integer pageNum;
    }

    @Builder
    public static class ActResponseDto{
        private List<PreviewDto> previewDtoList;
    }

}
