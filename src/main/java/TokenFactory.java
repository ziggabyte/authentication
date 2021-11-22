import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TokenFactory {
    public static Token makeToken() {
        return new Token("A token!");
    }
}
