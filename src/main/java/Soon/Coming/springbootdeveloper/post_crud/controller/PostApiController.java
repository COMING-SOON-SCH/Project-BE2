package Soon.Coming.springbootdeveloper.post_crud.controller;

import Soon.Coming.springbootdeveloper.post_crud.domain.Article;
import Soon.Coming.springbootdeveloper.post_crud.dto.AddArticleRequest;
import Soon.Coming.springbootdeveloper.post_crud.dto.ArticleResponse;
import Soon.Coming.springbootdeveloper.post_crud.dto.UpdateArticleRequest;
import Soon.Coming.springbootdeveloper.post_crud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PostApiController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Article> addArticle(@RequestBody @Validated AddArticleRequest request) {
        Article savedArticle = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = postService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<ArticleResponse> findArticle(@PathVariable long id) {
        Article article = postService.findById(id);

        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        postService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest request) {
        Article updatedArticle = postService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }
}
