package Soon.Coming.springbootdeveloper.post.controller;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import Soon.Coming.springbootdeveloper.post.dto.CreatePostRequest;
import Soon.Coming.springbootdeveloper.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PostController {

    private final PostService postService;

    //api post
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody @Validated CreatePostRequest createPostRequest){
        Post post = postService.createPost(createPostRequest);
        return ResponseEntity.ok().body(post);
    }
}
