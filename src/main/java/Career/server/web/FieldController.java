package Career.server.web;

import Career.server.web.dto.FieldRequestDto;
import Career.server.web.dto.FieldResponseDto;
import Career.server.service.FieldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/field")
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @PostMapping
    public ResponseEntity<FieldResponseDto> saveField(@RequestBody FieldRequestDto requestDto) {
        FieldResponseDto responseDto = fieldService.saveFieldData(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
