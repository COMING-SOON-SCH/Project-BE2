package soon.coming.springbootdeveloper.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private Long userCode;
    private String email;
    private String username;
    private String password;
}
