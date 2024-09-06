package Soon.Coming.springbootdeveloper.post.repository;

import Soon.Coming.springbootdeveloper.post.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
