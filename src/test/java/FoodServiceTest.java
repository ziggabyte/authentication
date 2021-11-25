import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testInvalidTokenFail() {
        Token invalidToken = new Token(
                "Invalid token", user, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        user.setToken(invalidToken);
        assertFalse(foodService.validateToken(invalidToken));
    }

    @Test
    public void testUserAndTokenMismatchFail() {
        Token invalidToken1 = new Token(
                "Invalid token", user, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        Token invalidToken2 = new Token(
                "Another invalid token", user, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        user.setToken(invalidToken1);
        assertFalse(foodService.validateToken(invalidToken2));
    }

    @Test
    public void testUserPermissions() throws LoginFailureException {
        loginService.login("anna", "losen");
        mockUsers.get("anna").getPermissions().put(FoodServiceResource.OVEN, FoodServicePermission.READ);
        FoodServicePermission expectedPermission = foodService.checkPermissions(
                user.getToken(), FoodServiceResource.OVEN);
        assertEquals(expectedPermission, FoodServicePermission.READ);
    }
}
