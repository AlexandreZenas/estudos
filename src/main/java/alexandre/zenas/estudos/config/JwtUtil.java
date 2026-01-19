package alexandre.zenas.estudos.config;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class JwtUtil {
    private static final String keySecret = "ABC-DEF-123-456";
    private static final String ALGORITHM = "HmacSHA256";
    private static final long EXPIRATION_TIME_SECONDS = System.currentTimeMillis() / 1000 + (60 * 60);

    public static String createHeaderJson(){
        return "{"
                +"\"alg\": \"" + ALGORITHM + "\" ,"
                +"\"typ\": \"JWT\" }";
    }
    private static String createPayloadJson() {
        // Exemplo de Claims (Dados)
        long now = System.currentTimeMillis() / 1000;
        return "{"
                + "\"sub\": \"user_id_123\","
                + "\"iat\": " + now + ","
                + "\"exp\": " + EXPIRATION_TIME_SECONDS
                + "}";
    }
    public static String toBase64URL(String data){
        return Base64
                .getEncoder()
                .withoutPadding()
                .encodeToString(data.getBytes(StandardCharsets.UTF_8));
    }

    public static String concatenate(String header, String payload){
        return  header + "." + payload;
    }
    public static byte[] generateSignature(String signingInput, String keySecret, String ALGORITHM) throws NoSuchAlgorithmException, InvalidKeyException {

        SecretKeySpec secretKeySpec = new SecretKeySpec(keySecret.getBytes(), ALGORITHM);
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretKeySpec);

        return mac.doFinal(signingInput.getBytes());
    }
}