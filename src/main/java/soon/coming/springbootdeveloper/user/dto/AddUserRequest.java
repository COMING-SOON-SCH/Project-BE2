package soon.coming.springbootdeveloper.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String userId;
    private String username;
    private String password;
}
