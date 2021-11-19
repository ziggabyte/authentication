import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class LoginService {
    private final Map<String, String> users;

    public boolean login(String username, String password) {
        if (users.containsKey(username)) {
            return users.get(username).equals(password);
        }
        return false;
    }
}
