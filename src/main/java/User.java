import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class User {
    private String username;
    private String password;
    private String salt;
    private Token token;
    Map<FoodServiceResource, FoodServicePermission> permissions;

    public User(String username, String password) {
        this.username = username;
        this.salt = PasswordUtils.generateSalt(512).get();
        this.password = PasswordUtils.hashPassword(password, salt).get();
        this.permissions = new HashMap<>();
    }
}
