package Career.server.web.controller;

import Career.server.service.ExpService;
import Career.server.web.dto.ExpRequestDto;
import Career.server.web.dto.ExpResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exp")
public class ExpController {
    private final ExpService expService;

    public ExpController(ExpService expService) {
        this.expService = expService;
    }

    @PostMapping
    public ResponseEntity<ExpResponseDto> saveExp(@RequestBody ExpRequestDto requestDto) {
        expService.saveExp(requestDto);
        ExpResponseDto response = new ExpResponseDto();
        response.setMessage("경력 저장이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }
}
