package Career.server.web.controller;

import Career.server.service.EduService;
import Career.server.web.dto.EduRequestDto;
import Career.server.web.dto.EduResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/edu")
public class EduController {
    private final EduService eduService;

    public EduController(EduService eduService) {
        this.eduService = eduService;
    }

    @PostMapping
    public ResponseEntity<EduResponseDto> saveEdu(@RequestBody EduRequestDto requestDto) {
        eduService.saveEdu(requestDto);
        EduResponseDto response = new EduResponseDto();
        response.setMessage("학력 저장이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }
}
