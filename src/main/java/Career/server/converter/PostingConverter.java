package Career.server.converter;

import Career.server.domain.mapping.Posting;
import Career.server.web.dto.PostingDto;

import java.util.List;
import java.util.stream.Collectors;

public class PostingConverter {
    public static PostingDto.DetailResponseDto toDetailResponseDto(Posting posting) {
        return PostingDto.DetailResponseDto.builder()
                .title(posting.getTitle())
                .corporateType(posting.getCorporateType().toString())
                .startAct(posting.getStartAct())
                .endAct(posting.getEndAct())
                .startDate(posting.getStartDate())
                .endDate(posting.getEndDate())
                .area(posting.getArea())
                .related(posting.getRelated())
                .salary(posting.getSalary())
                .homepageUrl(posting.getHomepageUrl())
                .imageUrl(posting.getImageUrl())
                .content(posting.getContent())
                .build();
    }

    public static PostingDto.PreviewDto toPreviewDto(Posting posting) {
        return PostingDto.PreviewDto.builder()
                .postingId(posting.getId())
                .title(posting.getTitle())
                .corporateType(posting.getCorporateType().toString())
                .imageUrl(posting.getImageUrl())
                .views(posting.getViews())
                .endDate(posting.getEndDate())
                .build();
    }

    public static PostingDto.MainResponseDto toMainResponseDto(List<PostingDto.PreviewDto> previewDtoList) {
        return PostingDto.MainResponseDto.builder()
                .previewDtoList(previewDtoList)
                .build();
    }

    public static PostingDto.ActResponseDto toActResponseDto(List<PostingDto.PreviewDto> previewDtoList) {
        return PostingDto.ActResponseDto.builder()
                .previewDtoList(previewDtoList)
                .build();
    }

}
