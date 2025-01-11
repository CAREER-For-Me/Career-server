package Career.server.web.controller;



import Career.server.apiPayload.ApiResponse;
import Career.server.service.PostingService;
import Career.server.web.dto.PostingDto;
import jakarta.validation.Valid;
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
    public ApiResponse<PostingDto.ActResponseDto> getPostingAct(@Valid @RequestBody PostingDto.ActRequestDto actRequestDto) {
        return ApiResponse.onSuccess(postingService.getPostingAct(actRequestDto));
    }

    @GetMapping("/search")
    public ApiResponse<PostingDto.SearchResponseDto> getPostingSearch(@Valid @RequestBody PostingDto.SearchRequestDto searchRequestDto) {
        return ApiResponse.onSuccess(postingService.getPostingSearch(searchRequestDto));
    }

    @PostMapping("/admin")
    public ApiResponse<PostingDto.AdminResponseDto> getPostingAdmin(@Valid @RequestBody PostingDto.AdminRequestDto adminRequestDto) {
        return ApiResponse.onSuccess(postingService.postPostingAdmin(adminRequestDto));
    }


}
