import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginServiceTest {
    LoginService loginService;
    Map<String, String> mockUsers;

    @BeforeEach
    public void setup() {
        mockUsers = new HashMap<>();
        mockUsers.put("anna", "losen");
        mockUsers.put("berit", "123456");
        mockUsers.put("kalle", "password");
        loginService = new LoginService(mockUsers);
    }

    @Test
    public void testLoginSuccess() {
        assertTrue(loginService.login("anna", "losen"));
    }

    @Test
    public void testLoginFail() {
        assertFalse(loginService.login("hanna", "lisen"));
    }
}
