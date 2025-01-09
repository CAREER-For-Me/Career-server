package Career.server.service;

import Career.server.web.dto.QualRequestDto;
import org.springframework.stereotype.Service;

@Service
public class QualService {
    public void saveQual(QualRequestDto requestDto) {
        // 자격증 저장 로직 구현
        System.out.println("자격증 저장: " + requestDto);
    }
}
