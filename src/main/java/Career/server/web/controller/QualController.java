package Career.server.web.controller;

import Career.server.service.QualService;
import Career.server.web.dto.QualRequestDto;
import Career.server.web.dto.QualResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/qual")
public class QualController {
    private final QualService qualService;

    public QualController(QualService qualService) {
        this.qualService = qualService;
    }

    @PostMapping
    public ResponseEntity<QualResponseDto> saveQual(@RequestBody QualRequestDto requestDto) {
        qualService.saveQual(requestDto);
        QualResponseDto response = new QualResponseDto();
        response.setMessage("자격증 저장이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }
}
