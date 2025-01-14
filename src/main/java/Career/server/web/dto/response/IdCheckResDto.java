package Career.server.web.dto.response;

import Career.server.apiPayload.authcode.ResponseCode;
import Career.server.apiPayload.authcode.ResponseMessage;
import Career.server.web.dto.BaseResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class IdCheckResDto extends BaseResponseDto {
    private IdCheckResDto() {
        super();
    }

    public static ResponseEntity<IdCheckResDto> success() {
        IdCheckResDto responseDto = new IdCheckResDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    public static ResponseEntity<BaseResponseDto> duplicateId(){
        BaseResponseDto responseBody = new BaseResponseDto(ResponseCode.DUPLICATE_ID, ResponseMessage.DUPLICATE_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}