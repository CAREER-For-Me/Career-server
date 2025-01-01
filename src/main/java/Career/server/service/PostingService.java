package Career.server.service;


import Career.server.apiPayload.code.status.ErrorStatus;
import Career.server.apiPayload.exception.GeneralException;
import Career.server.converter.PostingConverter;
import Career.server.domain.mapping.Posting;
import Career.server.repository.PostingRepository;
import Career.server.web.dto.PostingDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    public PostingDto.DetailResponseDto getPostingDetail(Long postingId) {
        Posting posting = postingRepository.findById(postingId).orElseThrow(()->new GeneralException(ErrorStatus._BAD_REQUEST));
        posting.incrementViews();
        return PostingConverter.toDetailResponseDto(posting);
    }

    public PostingDto.MainResponseDto getPostingMain(){
        List<Posting> postingList = postingRepository.findTop8ByOrderByViewsDesc();
        List<PostingDto.PreviewDto> previewDtoList = postingList.stream()
                .map(PostingConverter::toPreviewDto).toList();
        return PostingConverter.toMainResponseDto(previewDtoList);
    }
}
