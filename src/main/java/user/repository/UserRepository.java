package user.repository;

<<<<<<< HEAD:src/main/java/user/repository/UserRepository.java
import user.domain.User;
=======
import Soon.Coming.springbootdeveloper.userSignup.domain.User;
>>>>>>> e16905a (feat : 포스트 테스트 코드 제작중):src/main/java/Soon/Coming/springbootdeveloper/repository/UserRepository.java
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findbyUsername(String username); //username으로 사용자 정보 가져오기
}