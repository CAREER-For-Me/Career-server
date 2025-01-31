package Career.server.apiPayload.handler;

public class CertificationNumber {
    public static String getCertificationNumber() {
        StringBuilder certificationNum = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int count = 0; count < 9; count++) {
            int index = (int) (Math.random() * characters.length());
            certificationNum.append(characters.charAt(index));
        }

        return certificationNum.toString();
    }
}
