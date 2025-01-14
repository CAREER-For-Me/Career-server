package Career.server.apiPayload.authcode;

public interface ResponseMessage {
    String SUCCESS = "성공입니다.";
    String VALIDATION_FAIL = "유효성 검증 오류입니다.";
    String DUPLICATE_ID = "중복된 아이디입니다. 다른 아이디로 로그인 해 주세요.";
    String SIGN_IN_FAIL = "로그인 정보가 잘 못 되었습니다.";
    String MAIL_FAIL = "메일 전송 실패하였습니다.";
    String CERTIFICATION_FAIL = "인증 오류입니다. 틀린 철자가 없는지 확인해 보세요.";
    String DATABASE_ERROR = "데이터베이스 오류입니다. 연결 상태를 확인해 보세요.";
    //추후에 로그인 관련 오류 추가해야 함
}
