package Career.server.converter;

import Career.server.domain.enums.CorporateType;
import Career.server.domain.enums.PostingGubun;
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

    public static PostingDto.SearchResponseDto toSearchRequestDto(List<PostingDto.PreviewDto> previewDtoList) {
        return PostingDto.SearchResponseDto.builder()
                .previewDtoList(previewDtoList)
                .build();
    }

    public static PostingDto.AdminResponseDto toAdminResponseDto(String message) {
        return PostingDto.AdminResponseDto.builder()
                .message(message)
                .build();
    }

    public static Posting toPosting(PostingDto.AdminRequestDto adminRequestDto) {
        return Posting.builder()
                .title(adminRequestDto.getTitle())
                .corporateType(CorporateType.valueOf(adminRequestDto.getCorporateType()))
                .postingGubun(PostingGubun.valueOf(adminRequestDto.getPostingGubun()))
                .startAct(adminRequestDto.getStartAct())
                .endAct(adminRequestDto.getEndAct())
                .startDate(adminRequestDto.getStartDate())
                .endDate(adminRequestDto.getEndDate())
                .area(adminRequestDto.getArea())
                .related(adminRequestDto.getRelated())
                .salary(adminRequestDto.getSalary())
                .homepageUrl(adminRequestDto.getHomepageUrl())
                .imageUrl(adminRequestDto.getImageUrl())
                .content(adminRequestDto.getContent())
                .build();
    }

}
