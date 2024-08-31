package user.service;

<<<<<<< HEAD:src/main/java/user/service/UserDetailService.java

import user.domain.User;
import user.repository.UserRepository;
=======
import Soon.Coming.springbootdeveloper.userSignup.domain.User;
import Soon.Coming.springbootdeveloper.repository.UserRepository;
>>>>>>> e16905a (feat : í¬ìŠ¤íŠ¸ í…ŒìŠ¤íŠ¸ ì½”ë“œ ì œìž‘ì¤‘):src/main/java/Soon/Coming/springbootdeveloper/service/UserDetailService.java
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

//??¤í??ë§? ??????ë¦???°ì????? ????????? ???ë³´ë¥¼ ê°???¸ì?¤ë?? ??¸í?°í????´ì??
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    /**????????? ??´ë??(username) ??¼ë?? ???????????? ???ë³´ë¥¼ ê°???¸ì?¤ë?? ë©???????*/
    @Override
    public User loadUserByUsername(String username){
        return userRepository.findbyUsername(username)
                .orElseThrow(() -> new IllegalArgumentException(username));
    }
}
