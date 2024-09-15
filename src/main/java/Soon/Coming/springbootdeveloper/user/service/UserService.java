package Soon.Coming.springbootdeveloper.user.service;

import Soon.Coming.springbootdeveloper.user.dto.AddUserRequest;
import Soon.Coming.springbootdeveloper.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import Soon.Coming.springbootdeveloper.user.domain.User; //User ??´ê?? ì»¤ì?¤í????? ê±¸ë?? ??°ê¸°
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
