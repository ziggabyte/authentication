import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String salt;

    public User(String username, String password) {
        this.username = username;
        this.salt = PasswordUtils.generateSalt(512).get();
        this.password = PasswordUtils.hashPassword(password, salt).get();
    }
}
