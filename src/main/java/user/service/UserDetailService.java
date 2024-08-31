package user.service;

<<<<<<< HEAD:src/main/java/user/service/UserDetailService.java

import user.domain.User;
import user.repository.UserRepository;
=======
import Soon.Coming.springbootdeveloper.userSignup.domain.User;
import Soon.Coming.springbootdeveloper.repository.UserRepository;
>>>>>>> e16905a (feat : 포스트 테스트 코드 제작중):src/main/java/Soon/Coming/springbootdeveloper/service/UserDetailService.java
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

//스프링 시큐리티에서 사용자 정보를 가져오는 인터페이스
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    /**사용자 이름(username) 으로 사용자의 정보를 가져오는 메서드*/
    @Override
    public User loadUserByUsername(String username){
        return userRepository.findbyUsername(username)
                .orElseThrow(() -> new IllegalArgumentException(username));
    }
}
