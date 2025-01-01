package Career.server.web.controller;



import Career.server.apiPayload.ApiResponse;
import Career.server.service.PostingService;
import Career.server.web.dto.PostingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posting")
public class PostingController {
    private final PostingService postingService;

    @GetMapping("/detail")
    public ApiResponse<PostingDto.DetailResponseDto> getPostingDetail(@RequestParam Long postingId) {
        return ApiResponse.onSuccess(postingService.getPostingDetail(postingId));
    }

    @GetMapping("/main")
    public ApiResponse<PostingDto.MainResponseDto> getPostingMain(){
        return ApiResponse.onSuccess(postingService.getPostingMain());
    }

    @GetMapping("/act")
    public ApiResponse<PostingDto.ActResponseDto> getPostingAct(@RequestBody PostingDto.ActRequestDto actRequestDto) {
        return ApiResponse.onSuccess(postingService.getPostingAct(actRequestDto));
    }


}
