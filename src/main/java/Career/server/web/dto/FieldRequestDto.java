package Career.server.web.dto;

import java.util.List;

public class FieldRequestDto {
    private List<String> fieldName;

    public List<String> getFieldName() {
        return fieldName;
    }

    public void setFieldName(List<String> fieldName) {
        this.fieldName = fieldName;
    }
}
