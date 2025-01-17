package Career.server.service;


import Career.server.apiPayload.code.status.ErrorStatus;
import Career.server.apiPayload.exception.GeneralException;
import Career.server.converter.PostingConverter;
import Career.server.domain.mapping.Field;
import Career.server.domain.mapping.FieldPosting;
import Career.server.domain.mapping.Posting;
import Career.server.repository.FieldPostingRepository;
import Career.server.repository.FieldRepository;
import Career.server.repository.PostingRepository;
import Career.server.web.dto.PostingDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostingService {

    private final FieldRepository fieldRepository;
    private final PostingRepository postingRepository;
    private final FieldPostingRepository fieldPostingRepository;

    public PostingDto.DetailResponseDto getPostingDetail(Long postingId) {
        Posting posting = postingRepository.findById(postingId).orElseThrow(()->new GeneralException(ErrorStatus._BAD_REQUEST));
        posting.incrementViews();
        return PostingConverter.toDetailResponseDto(posting);
    }

    public PostingDto.MainResponseDto getPostingMain(){
        List<Posting> postingList = postingRepository.findTop8ByOrderByViewsDesc();
        List<PostingDto.PreviewDto> previewDtoList = postingList.stream().map(PostingConverter::toPreviewDto).toList();
        return PostingConverter.toMainResponseDto(previewDtoList);
    }

    public PostingDto.ActResponseDto getPostingAct(PostingDto.ActRequestDto actRequestDto) {
        Pageable pageable = PageRequest.of(actRequestDto.getPageNum(), 20);
        Page<Posting> postingPage = fieldPostingRepository.findPostingsByFieldIds(actRequestDto.getFieldIds(), actRequestDto.getPostingGubun(),pageable);
        List<PostingDto.PreviewDto> previewDtoList = postingPage.stream().map(PostingConverter::toPreviewDto).toList();
        return PostingConverter.toActResponseDto(previewDtoList);
    }

    public PostingDto.SearchResponseDto getPostingSearch(PostingDto.SearchRequestDto searchRequestDto) {
        Pageable pageable = PageRequest.of(searchRequestDto.getPageNum(), 20);
        String keyword = searchRequestDto.getKeyword();
        Page<Posting> postingPage = postingRepository.findByTitleContainingOrderByViewsDesc(keyword, pageable);
        List<PostingDto.PreviewDto> previewDtoList = postingPage.stream().map(PostingConverter::toPreviewDto).toList();
        return PostingConverter.toSearchRequestDto(previewDtoList);
    }

    public PostingDto.AdminResponseDto postPostingAdmin(PostingDto.AdminRequestDto adminRequestDto) {
        Posting posting = PostingConverter.toPosting(adminRequestDto);
        postingRepository.save(posting);

        List<Field> fields = fieldRepository.findAllById(adminRequestDto.getFieldIds());

        for(Field field : fields) {
            FieldPosting fieldPosting = FieldPosting.builder().build();
            fieldPosting.setPosting(posting);
            fieldPosting.setField(field);
            fieldPostingRepository.save(fieldPosting);
        }

        return PostingConverter.toAdminResponseDto("정상적으로 공고 입력 완료되었습니다.");
    }
}
