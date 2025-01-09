package Career.server.service;

import Career.server.web.dto.EduRequestDto;
import org.springframework.stereotype.Service;

@Service
public class EduService {
    public void saveEdu(EduRequestDto requestDto) {
        // 학력 정보를 저장하는 로직 구현
        System.out.println("학력 저장: " + requestDto);
    }
}
