import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FoodService {
    public boolean validateToken(Token token) {
        return token.getTokenString().equals("A token!");
    }
}