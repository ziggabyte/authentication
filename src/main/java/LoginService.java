import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginService {
    private final String username;
    private final String password;

    public boolean login(String username, String password) {
        if (this.username.equals(username)) {
            return this.password.equals(password);
        }
        return false;
    }
}
