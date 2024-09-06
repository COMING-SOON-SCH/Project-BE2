package user.repository;

import user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findbyUsername(String username); //username??¼ë?? ????????? ???ë³? ê°???¸ì?¤ê¸°
}