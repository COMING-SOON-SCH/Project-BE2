package Soon.Coming.springbootdeveloper.service;

import Soon.Coming.springbootdeveloper.domain.User;
import Soon.Coming.springbootdeveloper.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
//JSDoc 처음 써보는데 이거이거 아주 깔@롱한데? 멋져

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
