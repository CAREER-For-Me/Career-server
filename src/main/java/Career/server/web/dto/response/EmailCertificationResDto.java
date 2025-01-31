package Career.server.web.dto.response;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class EmailCertificationResDto{

    private EmailCertificationResDto(){
        super();
    }

    public static ResponseEntity<EmailCertificationResDto> success(){
        EmailCertificationResDto responseBody = new EmailCertificationResDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

}
