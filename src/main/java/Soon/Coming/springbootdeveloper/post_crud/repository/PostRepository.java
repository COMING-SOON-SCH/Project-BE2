package Soon.Coming.springbootdeveloper.post_crud.repository;

import Soon.Coming.springbootdeveloper.post_crud.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Article, Long> {
}
