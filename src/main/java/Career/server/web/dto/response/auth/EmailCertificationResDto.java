package Career.server.web.dto.response.auth;

import Career.server.apiPayload.code.status.ResponseCode;
import Career.server.apiPayload.code.status.ResponseMessage;
import Career.server.web.dto.response.BaseResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class EmailCertificationResDto extends BaseResponseDto {

    private EmailCertificationResDto(){
        super();
    }

    public static ResponseEntity<EmailCertificationResDto> success(){
        EmailCertificationResDto responseBody = new EmailCertificationResDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<BaseResponseDto> duplicateEmail(){
        BaseResponseDto responseBody = new BaseResponseDto(ResponseCode.DUPLICATE_ID, ResponseMessage.DUPLICATE_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<BaseResponseDto> mailSendFail(){
        BaseResponseDto responseBody = new BaseResponseDto(ResponseCode.MAIL_FAIL, ResponseMessage.MAIL_FAIL);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
