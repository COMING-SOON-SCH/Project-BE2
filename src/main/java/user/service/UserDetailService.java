<<<<<<<< HEAD:src/main/java/user/userSignup/service/UserDetailService.java
<<<<<<<< HEAD:src/main/java/user/service/UserDetailService.java
package user.service;

<<<<<<< HEAD:src/main/java/user/service/UserDetailService.java

import user.domain.User;
import user.repository.UserRepository;
=======
import Soon.Coming.springbootdeveloper.userSignup.domain.User;
import Soon.Coming.springbootdeveloper.repository.UserRepository;
>>>>>>> e16905a (feat : ?????��?? ?????��?? �???? ??????�?):src/main/java/Soon/Coming/springbootdeveloper/service/UserDetailService.java
========
package user.userSignup.service;

import user.userSignup.domain.User;
import user.userSignup.repository.UserRepository;
>>>>>>>> 59490f7 (feat : �? 조�?? api ??????�?. sql ??�결??��?��??):src/main/java/user/userSignup/service/UserDetailService.java
========
package user.service;

import user.domain.User;
import user.repository.UserRepository;
>>>>>>>> 740d98a (feat : sql ??�결못�??):src/main/java/user/service/UserDetailService.java
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
