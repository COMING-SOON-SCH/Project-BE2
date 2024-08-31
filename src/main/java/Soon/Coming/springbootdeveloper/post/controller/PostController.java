package Soon.Coming.springbootdeveloper.post.controller;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import Soon.Coming.springbootdeveloper.post.dto.CreatePostRequest;
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
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    // 게시글 생성 (POST)
    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody CreatePostRequest request) {
        Post savedPost = postService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPost);
    }

    // 모든 게시글 조회 (GET)
    @GetMapping
    public ResponseEntity<List<PostResponse>> findAllPosts() {
        List<PostResponse> posts = postService.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(posts);
    }

    // 특정 게시글 조회 (GET)
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findPost(@PathVariable long id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok()
                .body(new PostResponse(post));
    }

    // 게시글 삭제 (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable long id) {
        postService.delete(id);
        return ResponseEntity.ok()
                .build();
    }

    // 게시글 수정 (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable long id,
                                           @RequestBody UpdatePostRequest request) {
        Post updatedPost = postService.update(id, request);
        return ResponseEntity.ok()
                .body(updatedPost);
    }
}
