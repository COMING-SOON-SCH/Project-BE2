package Soon.Coming.springbootdeveloper.post.service;

import Soon.Coming.springbootdeveloper.post.domain.Article;
import Soon.Coming.springbootdeveloper.post.dto.AddArticleRequest;
import Soon.Coming.springbootdeveloper.post.dto.UpdateArticleRequest;
import Soon.Coming.springbootdeveloper.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Article save(AddArticleRequest request) {
        return postRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return postRepository.findAll();
    }

    public Article findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());
        return article;
    }
}

