import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class FoodService {
    public boolean validateToken(Token token) {
        if (token.getTokenString().equals(token.getUser().getToken().getTokenString())) {
            return token.getExpiration().isAfter(LocalDateTime.now());
        }
        return false;
    }

    public FoodServicePermission checkPermissions(Token token, FoodServiceResource resource)  {
        return token.getUser().getPermissions().get(resource);
    }
}
