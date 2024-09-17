package Soon.Coming.springbootdeveloper.user.service;

import Soon.Coming.springbootdeveloper.user.dto.AddUserRequest;
import Soon.Coming.springbootdeveloper.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Object save(AddUserRequest dto){
        return userRepository.save(User.builder()
                .
        )


    }
}
