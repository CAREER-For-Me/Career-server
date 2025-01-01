package Career.server.converter;

import Career.server.domain.mapping.Posting;
import Career.server.web.dto.PostingDto;

public class PostingDtoConverter {
    public static PostingDto.DetailResponseDto toDetailResponseDto(Posting posting) {
        return PostingDto.DetailResponseDto.builder()
                .title(posting.getTitle()).build(); // 이런식으로.
    }
}
