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

//??��??�? ??????�???��????? ????????? ???보를 �???��?��?? ??��?��????��??
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    /**????????? ??��??(username) ??��?? ???????????? ???보를 �???��?��?? �???????*/
    @Override
    public User loadUserByUsername(String username){
        return userRepository.findbyUsername(username)
                .orElseThrow(() -> new IllegalArgumentException(username));
    }
}
