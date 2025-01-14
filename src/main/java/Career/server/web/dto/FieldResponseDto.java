package Career.server.web.dto;

public class FieldResponseDto {
    private String message;

    public FieldResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
