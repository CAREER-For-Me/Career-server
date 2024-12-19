package Career.server.apiPayload.exception.handler;

import Career.server.apiPayload.code.BaseErrorCode;
import Career.server.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
