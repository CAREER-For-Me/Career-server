package Career.server.web.controller;

import Career.server.service.SkillService;
import Career.server.web.dto.SkillRequestDto;
import Career.server.web.dto.SkillResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/skill")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<SkillResponseDto> saveSkill(@RequestBody SkillRequestDto requestDto) {
        skillService.saveSkill(requestDto);
        SkillResponseDto response = new SkillResponseDto();
        response.setMessage("보유 스킬 저장이 완료되었습니다.");
        return ResponseEntity.ok(response);
    }
}
