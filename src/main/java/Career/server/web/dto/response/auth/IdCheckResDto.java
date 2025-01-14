package Career.server.web.dto.response.auth;

import Career.server.apiPayload.code.status.ResponseCode;
import Career.server.apiPayload.code.status.ResponseMessage;
import Career.server.web.dto.response.BaseResponseDto;
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
