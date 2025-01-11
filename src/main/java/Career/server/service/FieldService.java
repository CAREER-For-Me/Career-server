package Career.server.service;

import Career.server.web.dto.FieldRequestDto;
import Career.server.web.dto.FieldResponseDto;
import org.springframework.stereotype.Service;

@Service
public class FieldService {

    public FieldResponseDto saveFieldData(FieldRequestDto requestDto) {
        System.out.println("Received field data: " + requestDto.getFieldName());
        return new FieldResponseDto("Field data saved successfully for: " + requestDto.getFieldName());
    }
}
