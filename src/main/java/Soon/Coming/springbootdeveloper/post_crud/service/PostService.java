package Soon.Coming.springbootdeveloper.post_crud.service;

import Soon.Coming.springbootdeveloper.post_crud.domain.Article;
import Soon.Coming.springbootdeveloper.post_crud.dto.AddArticleRequest;
import Soon.Coming.springbootdeveloper.post_crud.dto.UpdateArticleRequest;
import Soon.Coming.springbootdeveloper.post_crud.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    //생성
    public Article save(AddArticleRequest request) {
        return postRepository.save(request.toEntity());
    }

    //전체 조회
    public List<Article> findAll() {
        return postRepository.findAll();
    }

    //하나 조회
    public Article findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));
    }

    //삭제
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    //수정
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+ id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
