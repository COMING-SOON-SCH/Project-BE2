package Soon.Coming.springbootdeveloper.post.repository;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
