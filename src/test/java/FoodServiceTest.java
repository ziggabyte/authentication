import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FoodServiceTest {
    FoodService foodService;
    LoginService loginService;
    User user;
    Map<String, User> mockUsers;

    @BeforeEach
    public void setup() {
        user = new User("anna", "losen");
        mockUsers = new HashMap<>();
        mockUsers.put(user.getUsername(), user);
        loginService = new LoginService(mockUsers);
        foodService = new FoodService();
    }

    @Test
    public void testValidTokenSuccess() throws LoginFailureException {
        loginService.login("anna", "losen");
        assertTrue(foodService.validateToken(user.getToken()));
    }

    @Test
    public void testValidTokenFail() {
        Token invalidToken = new Token("Invalid token", user);
        assertFalse(foodService.validateToken(invalidToken));
    }
}
