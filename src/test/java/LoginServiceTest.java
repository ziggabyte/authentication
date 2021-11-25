import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testLoginSuccessReturnsToken() throws LoginFailureException {
        assertNotNull(loginService.login("anna", "losen"));
        assertEquals( 32, loginService.login("anna", "losen").length() );
    }

    @Test
    public void testLoginSuccessSetsUserToken() throws LoginFailureException {
        loginService.login("anna", "losen");
        assertNotNull(mockUsers.get("anna").getToken());
    }

    @Test
    public void testLoginUsernameFailThrowsException() {
        assertThrows(LoginFailureException.class, () -> loginService.login("hanna", "lisen"));
    }

    @Test
    public void testLoginPasswordFailThrowsException() {
        assertThrows(LoginFailureException.class, () -> loginService.login("anna", "lisen"));
    }
}
