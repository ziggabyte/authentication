import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LoginServiceTest {
    LoginService loginService;
    Map<String, User> mockUsers;

    @BeforeEach
    public void setup() {
        mockUsers = new HashMap<>();
        mockUsers.put("anna", new User("anna","losen"));
        mockUsers.put("berit", new User("berit", "123456"));
        mockUsers.put("kalle", new User("kalle", "password"));
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
