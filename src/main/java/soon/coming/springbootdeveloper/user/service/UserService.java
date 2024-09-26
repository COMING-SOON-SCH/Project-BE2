package soon.coming.springbootdeveloper.user.service;

import soon.coming.springbootdeveloper.user.dto.AddUserRequest;
import soon.coming.springbootdeveloper.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import soon.coming.springbootdeveloper.user.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto){
        return userRepository.save(User.builder()
                        .userId(dto.getUserId())
                        .email(dto.getEmail())
                        .username(dto.getUsername())
                        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getUserId();
    }
}
