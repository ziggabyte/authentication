import lombok.Data;

@Data
public class Token {
    private final String tokenString;
    private final User user;
}
