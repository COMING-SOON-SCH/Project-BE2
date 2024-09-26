package soon.coming.springbootdeveloper.user.service;


import soon.coming.springbootdeveloper.user.domain.User;
import soon.coming.springbootdeveloper.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    /** 사용자 이름(username)으로 사용자의 정보를 가져오는 메서드 */
    @Override
    public User loadUserByUsername(String username) {
        return (User) userRepository.findByUsername(username) // findByUsername으로 수정
                .orElseThrow(() -> new UsernameNotFoundException("User를 해당 username으로 찾을 수 없습니다!: " + username));
    }
}
