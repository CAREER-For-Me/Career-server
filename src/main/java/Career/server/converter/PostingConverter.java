package Career.server.converter;

import Career.server.domain.mapping.Posting;
import Career.server.web.dto.PostingDto;

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

}
