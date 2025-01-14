package Career.server.web.dto;

import java.util.List;

public class SkillRequestDto {
    private List<String> skillName;

    public List<String> getSkillName() {
        return skillName;
    }

    public void setSkillName(List<String> skillName) {
        this.skillName = skillName;
    }
}
