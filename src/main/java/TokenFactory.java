import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TokenFactory {
    public static Token makeToken(User user) {
        return new Token("A token!", user);
    }
}
