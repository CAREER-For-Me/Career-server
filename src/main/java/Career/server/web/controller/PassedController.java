package Career.server.web.controller;

import Career.server.apiPayload.ApiResponse;
import Career.server.domain.enums.Major;
import Career.server.repository.PassedRepository;
import Career.server.service.PassedService;
import Career.server.web.dto.MySpecDto;
import Career.server.web.dto.response.PassedResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PassedController {

    private final PassedService passedService;

    @GetMapping("/avgspec")
    public ApiResponse<PassedResponseDto> getPassedSpec(@RequestParam("major") Major major) {
        return ApiResponse.onSuccess(passedService.findAvgPassedSpec(major));
    }
}
