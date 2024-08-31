package user.userSignup.repository;

import user.userSignup.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findbyUsername(String username); //username으로 사용자 정보 가져오기
}
