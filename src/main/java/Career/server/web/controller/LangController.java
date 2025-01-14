package Career.server.web.controller;

import Career.server.service.LangService;
import Career.server.web.dto.LangRequestDto;
import Career.server.web.dto.LangResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lang")
public class LangController {
    private final LangService langService;

    public LangController(LangService langService) {
        this.langService = langService;
    }

    @PostMapping
    public ResponseEntity<LangResponseDto> saveLang(@RequestBody LangRequestDto requestDto) {
        langService.saveLang(requestDto);
        LangResponseDto response = new LangResponseDto();
        response.setMessage("어학 저장이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }
}
