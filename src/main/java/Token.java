import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Token {
    private final String tokenString;
    private final User user;
    private final LocalDateTime expiration;
}
