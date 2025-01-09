package Career.server.service;

import Career.server.web.dto.LangRequestDto;
import org.springframework.stereotype.Service;

@Service
public class LangService {
    public void saveLang(LangRequestDto requestDto) {
        // 어학 저장 로직 구현
        System.out.println("어학 저장: " + requestDto);
    }
}