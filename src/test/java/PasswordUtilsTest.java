import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PasswordUtilsTest {

    @Test
    public void correctlyHashesAPassword() {
        String salt = PasswordUtils.generateSalt(512).get();
        String hashedPassword = PasswordUtils.hashPassword("losen", salt).get();
        assertTrue(PasswordUtils.verifyPassword("losen", hashedPassword, salt));
    }
}
