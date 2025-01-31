package Career.server.apiPayload.handler;

import Career.server.apiPayload.code.BaseErrorCode;
import Career.server.apiPayload.exception.GeneralException;

public class AuthHandler extends GeneralException {
    public AuthHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
