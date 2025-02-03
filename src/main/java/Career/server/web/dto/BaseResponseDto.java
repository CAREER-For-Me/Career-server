package Career.server.web.dto;

import Career.server.apiPayload.authcode.ResponseCode;
import Career.server.apiPayload.authcode.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class BaseResponseDto {

    private String code;
    private String message;


    public BaseResponseDto() {
        this.code = ResponseCode.SUCCESS;
        this.message = ResponseMessage.SUCCESS;
    }

    public static ResponseEntity<BaseResponseDto> databaseError() {
        BaseResponseDto responseBody = new BaseResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    public static ResponseEntity<BaseResponseDto> validationFail() {
        BaseResponseDto responseBody = new BaseResponseDto(ResponseCode.VALIDATION_FAIL, ResponseMessage.VALIDATION_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
