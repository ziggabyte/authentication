import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class LoginService {
    private final Map<String, User> users;

    public String login(String username, String password) throws LoginFailureException {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (PasswordUtils.verifyPassword(password, user.getPassword(), user.getSalt())) {
                user.setToken(TokenFactory.makeToken(user));
                return user.getToken().getTokenString();
            } else {
                throw new LoginFailureException("The password is incorrect");
            }
        } else {
            throw new LoginFailureException("The user does not exist");
        }
    }
}
