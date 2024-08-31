<<<<<<<< HEAD:src/main/java/user/userSignup/service/UserDetailService.java
<<<<<<<< HEAD:src/main/java/user/service/UserDetailService.java
package user.service;

<<<<<<< HEAD:src/main/java/user/service/UserDetailService.java

import user.domain.User;
import user.repository.UserRepository;
=======
import Soon.Coming.springbootdeveloper.userSignup.domain.User;
import Soon.Coming.springbootdeveloper.repository.UserRepository;
>>>>>>> e16905a (feat : ?????¤í?? ?????¤í?? ì½???? ??????ì¤?):src/main/java/Soon/Coming/springbootdeveloper/service/UserDetailService.java
========
package user.userSignup.service;

import user.userSignup.domain.User;
import user.userSignup.repository.UserRepository;
>>>>>>>> 59490f7 (feat : ê¸? ì¡°í?? api ??????ì¤?. sql ??´ê²°??´ì?¼í??):src/main/java/user/userSignup/service/UserDetailService.java
========
package user.service;

import user.domain.User;
import user.repository.UserRepository;
>>>>>>>> 740d98a (feat : sql ??´ê²°ëª»í??):src/main/java/user/service/UserDetailService.java
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
