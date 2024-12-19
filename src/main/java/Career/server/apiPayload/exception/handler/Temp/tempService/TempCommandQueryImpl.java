package Career.server.apiPayload.exception.handler.Temp.tempService;

import Career.server.apiPayload.code.status.ErrorStatus;
import Career.server.apiPayload.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempCommandQueryImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1)
            throw new TempHandler(ErrorStatus._TEMP_EXCEPTION);
    }
}
