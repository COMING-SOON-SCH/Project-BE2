package soon.coming.springbootdeveloper.user.service;

import soon.coming.springbootdeveloper.user.dto.AddUserRequest;
import soon.coming.springbootdeveloper.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import soon.coming.springbootdeveloper.user.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UUID save(AddUserRequest dto) {
        // 서버에서 UUID를 생성하여 userCode에 할당
        UUID generatedUserCode = UUID.randomUUID();

        // User 엔티티를 빌드할 때 생성된 UUID를 사용
        return userRepository.save(User.builder()
                    .userCode(generatedUserCode)  // 서버에서 생성된 UUID 할당
                    .userId(dto.getUserId())
                    .username(dto.getUsername())
                    .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                .build()).getUserCode();
    }
}
