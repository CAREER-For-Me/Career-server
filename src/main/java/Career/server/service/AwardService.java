package Career.server.service;

import Career.server.web.dto.AwardRequestDto;
import org.springframework.stereotype.Service;

@Service
public class AwardService {
    public void saveAward(AwardRequestDto requestDto) {
        // 소상내역 저장 로직 구현
        System.out.println("소상내역 저장: " + requestDto);
    }
}
