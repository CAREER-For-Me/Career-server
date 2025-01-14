package Career.server.service;

import Career.server.web.dto.SkillRequestDto;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    public void saveSkill(SkillRequestDto requestDto) {
        // 스킬 저장 로직 구현
        System.out.println("스킬 저장: " + requestDto);
    }
}
