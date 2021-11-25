import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Base64;

public class TokenFactory {
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public static Token makeToken(User user) {
        return new Token(generateTokenString(), user, generateTokenExpirationTime());
    }

    private static String generateTokenString() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

    private static LocalDateTime generateTokenExpirationTime() {
        return LocalDateTime.of(LocalDate.now(), LocalTime.now()).plusHours(1);
    }
}
