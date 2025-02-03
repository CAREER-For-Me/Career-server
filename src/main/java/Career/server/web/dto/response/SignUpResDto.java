package Career.server.web.dto.response;


import Career.server.apiPayload.authcode.ResponseCode;
import Career.server.apiPayload.authcode.ResponseMessage;
import Career.server.web.dto.BaseResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class SignUpResDto extends BaseResponseDto {

    private SignUpResDto(){
        super();
    }

    public static ResponseEntity<SignUpResDto> success() {
        SignUpResDto responseBody = new SignUpResDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<BaseResponseDto> duplicateId() {
        BaseResponseDto responseBody = new BaseResponseDto(ResponseCode.DUPLICATE_ID, ResponseMessage.DUPLICATE_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<BaseResponseDto> certificationFail() {
        BaseResponseDto responseBody = new BaseResponseDto(ResponseCode.CERTIFICATION_FAIL, ResponseMessage.CERTIFICATION_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
}
