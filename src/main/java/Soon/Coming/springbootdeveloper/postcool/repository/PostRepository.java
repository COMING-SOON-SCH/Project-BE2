package Soon.Coming.springbootdeveloper.postcool.repository;

import Soon.Coming.springbootdeveloper.postcool.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
