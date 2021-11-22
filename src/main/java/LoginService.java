import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class LoginService {
    private final Map<String, User> users;

    public boolean login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            return PasswordUtils.verifyPassword(password, user.getPassword(), user.getSalt());
        }
        return false;
    }
}
