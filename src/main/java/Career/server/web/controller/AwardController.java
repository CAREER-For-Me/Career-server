package Career.server.web.controller;

import Career.server.service.AwardService;
import Career.server.web.dto.AwardRequestDto;
import Career.server.web.dto.AwardResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/award")
public class AwardController {
    private final AwardService awardService;

    public AwardController(AwardService awardService) {
        this.awardService = awardService;
    }

    @PostMapping
    public ResponseEntity<AwardResponseDto> saveAward(@RequestBody AwardRequestDto requestDto) {
        awardService.saveAward(requestDto);
        AwardResponseDto response = new AwardResponseDto();
        response.setMessage("소상내역 저장이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }
}
