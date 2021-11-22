import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FoodService {
    public boolean validateToken(Token token) {
        return token.getToken().equals("A token!");
    }
}
