package Soon.Coming.springbootdeveloper.post.repository;

import Soon.Coming.springbootdeveloper.post.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Article, Long> {
}
