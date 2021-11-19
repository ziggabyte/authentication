import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LoginServiceTest {
    LoginService loginService = new LoginService("anna", "losen");

    @Test
    public void testLoginSuccess() {
        assertTrue(loginService.login("anna", "losen"));
    }

    @Test
    public void testLoginFail() {
        assertFalse(loginService.login("hanna", "lisen"));
    }
}
