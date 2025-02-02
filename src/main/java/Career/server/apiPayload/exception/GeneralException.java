package Career.server.apiPayload.exception;

import Career.server.apiPayload.code.BaseErrorCode;
import Career.server.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class GeneralException extends RuntimeException{

    private BaseErrorCode code;

    public GeneralException(String message) {
        super(message);
        this.code = null;
    }

    public GeneralException(BaseErrorCode code){
        super(code.getReason().getMessage());
        this.code = code;
    }

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }
}
