package soon.coming.springbootdeveloper.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private Long userId;
    private String email;
    private String username;
    private String password;
}
