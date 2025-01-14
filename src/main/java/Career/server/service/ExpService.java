package Career.server.service;

import Career.server.web.dto.ExpRequestDto;
import org.springframework.stereotype.Service;

@Service
public class ExpService {
    public void saveExp(ExpRequestDto requestDto) {
        // 경력 정보를 저장하는 로직
        System.out.println("경력 저장: " + requestDto);
    }
}
