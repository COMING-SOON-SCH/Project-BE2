package Soon.Coming.springbootdeveloper.post.controller;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import Soon.Coming.springbootdeveloper.post.dto.AddPostRequest;
import Soon.Coming.springbootdeveloper.post.dto.PostResponse;
import Soon.Coming.springbootdeveloper.post.dto.UpdatePostRequest;
import Soon.Coming.springbootdeveloper.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
public class PostApiController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<Long> addArticle(@RequestBody AddPostRequest request) {
        Long articleId = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(articleId);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> findAllArticles() {
        List<PostResponse> articles = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> findArticle(@PathVariable long id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok()
                .body(new PostResponse(post));
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        postService.delete(id);
        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updateArticle(@PathVariable long id,
                                              @RequestBody UpdatePostRequest request) {
        Post updatedPost = postService.update(id, request);
        return ResponseEntity.ok()
                .body(updatedPost);
    }
}