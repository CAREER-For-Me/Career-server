package Career.server.web.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
        @NotBlank
        private List<Long> fieldIds;

        @NotBlank
        @Min(value = 0, message = "Gubun 값은 0이상 4이하이어야 합니다.")
        @Max(value = 4, message = "Gubun 값은 0이상 4이하이어야 합니다.")
        private Integer postingGubun;

        @NotBlank
        private Integer pageNum;
    }

    @Builder
    public static class ActResponseDto{
        private List<PreviewDto> previewDtoList;
    }

    @Getter
    public static class SearchRequestDto{

        @NotBlank
        private String keyword;

        @NotBlank
        private Integer pageNum;
    }

    @Builder
    public static class SearchResponseDto{
        private List<PreviewDto> previewDtoList;
    }

    @Getter
    public static class AdminRequestDto{
        private List<Long> fieldIds;
        private String title;
        private String corporateType;
        private String postingGubun;
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
    public static class AdminResponseDto{
        private String message;
    }

}
