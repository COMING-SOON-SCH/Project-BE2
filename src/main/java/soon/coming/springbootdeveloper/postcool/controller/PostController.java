package soon.coming.springbootdeveloper.postcool.controller;

import soon.coming.springbootdeveloper.postcool.domain.Post;
import soon.coming.springbootdeveloper.postcool.dto.AddPostRequest;
import soon.coming.springbootdeveloper.postcool.dto.PostResponse;
import soon.coming.springbootdeveloper.postcool.dto.UpdatePostRequest;
import soon.coming.springbootdeveloper.postcool.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    //postService->postService2로 바꿈
    private final PostService postService2;

    // 게시물 생성
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@Validated @RequestBody AddPostRequest createPostRequest) {
        Post savedPost = postService2.createPost(createPostRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new PostResponse(savedPost));
    }

    // 특정 게시물 조회
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long postId) {
        Post post = postService2.getPost(postId);
        return ResponseEntity.ok()
                .body(new PostResponse(post));
    }

    // 모든 게시물 조회
    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<PostResponse> posts = postService2.getAllPosts()
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok()
                .body(posts);
    }

    // 게시물 수정
    @PutMapping("/{postId}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long postId, @Validated @RequestBody UpdatePostRequest updatePostRequest) {
        Post updatedPost = postService2.update(postId, updatePostRequest);
        return ResponseEntity.ok()
                .body(new PostResponse(updatedPost));
    }

    // 게시물 삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService2.delete(postId);
        return ResponseEntity.ok()
                .build();
    }
}
