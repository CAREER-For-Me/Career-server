package Career.server.apiPayload.exception.handler.Temp;

public class TempConverter {

    public static TempResponseDTO.TempTestDTO toTempTestDTO() {
        return TempResponseDTO.TempTestDTO.builder()
                .testString("This is test!")
                .build();
    }

    public static TempResponseDTO.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponseDTO.TempExceptionDTO.builder()
                .flag(flag)
                .build();
    }
}
