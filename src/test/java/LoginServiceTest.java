import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Token expectedToken = TokenFactory.makeToken(mockUsers.get("anna"));
        assertEquals(expectedToken.getTokenString(), loginService.login("anna", "losen") );
    }

    @Test
    public void testLoginSuccessSetsUserToken() throws LoginFailureException {
        Token expectedToken = TokenFactory.makeToken(mockUsers.get("anna"));
        loginService.login("anna", "losen");
        assertEquals(expectedToken.getTokenString(), mockUsers.get("anna").getToken().getTokenString());
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
