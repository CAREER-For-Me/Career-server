package Career.server.web.controller;

import Career.server.service.FieldService;
import Career.server.web.dto.FieldRequestDto;
import Career.server.web.dto.FieldResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/field")
public class FieldController {

    private final FieldService fieldService;

    // Constructor for dependency injection
    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    // Handle POST requests for saving field data
    @PostMapping
    public ResponseEntity<FieldResponseDto> saveFieldData(@RequestBody FieldRequestDto requestDto) {
        FieldResponseDto responseDto = fieldService.saveFieldData(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
