package user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private Long userId;
    private String userName;
    private String password;
    private String email;
}
