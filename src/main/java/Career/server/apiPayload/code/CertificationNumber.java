package Career.server.apiPayload.code;

public class CertificationNumber {

    public static String getCertificationNumber() {
        String certificationNum = "";

        for(int count = 0; count < 4 ; count++)
            certificationNum += (int) (Math.random() * 10);

        return certificationNum;
    }
}
