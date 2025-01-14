package Career.server.web.dto.response;

import Career.server.web.dto.BaseResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class CheckCertificationResDto extends BaseResponseDto {

    private CheckCertificationResDto() {
        super();
    }

    public static ResponseEntity<CheckCertificationResDto> success(){
        CheckCertificationResDto responseDto = new CheckCertificationResDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    public static ResponseEntity<BaseResponseDto> certificationFail() {
        BaseResponseDto responseDto = new BaseResponseDto();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
    }
}
