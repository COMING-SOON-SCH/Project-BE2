<<<<<<<< HEAD:src/main/java/user/userSignup/repository/UserRepository.java
<<<<<<<< HEAD:src/main/java/user/repository/UserRepository.java
package user.repository;

<<<<<<< HEAD:src/main/java/user/repository/UserRepository.java
import user.domain.User;
=======
import Soon.Coming.springbootdeveloper.userSignup.domain.User;
>>>>>>> e16905a (feat : ?????¤í?? ?????¤í?? ì½???? ??????ì¤?):src/main/java/Soon/Coming/springbootdeveloper/repository/UserRepository.java
========
package user.userSignup.repository;

import user.userSignup.domain.User;
>>>>>>>> 59490f7 (feat : ê¸? ì¡°í?? api ??????ì¤?. sql ??´ê²°??´ì?¼í??):src/main/java/user/userSignup/repository/UserRepository.java
========
package user.repository;

import user.domain.User;
>>>>>>>> 740d98a (feat : sql ??´ê²°ëª»í??):src/main/java/user/repository/UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findbyUsername(String username); //username??¼ë?? ????????? ???ë³? ê°???¸ì?¤ê¸°
}