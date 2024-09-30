package soon.coming.springbootdeveloper.post.controller;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import Soon.Coming.springbootdeveloper.post.dto.AddPostRequest;
import Soon.Coming.springbootdeveloper.post.dto.PostResponse;
import Soon.Coming.springbootdeveloper.post.dto.UpdatePostRequest;
import Soon.Coming.springbootdeveloper.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/")
@Tag(name = "POST", description = "post API")
public class PostApiController {

    private final PostService postService;

    @Operation(summary = "게시물 생성", description = "새로운 게시물 생성 API")
    @PostMapping("/posts")
    public ResponseEntity<Long> addArticle(@RequestBody AddPostRequest request) {
        Long articleId = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(articleId);
    }

    @Operation(summary = "모든 게시물 조회", description = "생성된 모든 게시물 조회 API")
    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> findAllArticles() {
        List<PostResponse> articles = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(articles);
    }

    @Operation(summary = "특정 게시물 조회", description = "하나의 게시물 조회 API")
    @GetMapping("/posts/{id}")
    public ResponseEntity<PostResponse> findArticle(@PathVariable long id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok()
                .body(new PostResponse(post));
    }

    @Operation(summary = "게시물 삭제", description = "하나의 게시물 삭제 API")
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
        postService.delete(id);
        return ResponseEntity.ok()
                .build();
    }

    @Operation(summary = "게시물 수정", description = "기존의 게시물 수정 API")
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updateArticle(@PathVariable long id,
                                              @RequestBody UpdatePostRequest request) {
        Post updatedPost = postService.update(id, request);
        return ResponseEntity.ok()
                .body(updatedPost);
    }
}
