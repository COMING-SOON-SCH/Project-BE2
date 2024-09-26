package Soon.Coming.springbootdeveloper.postcool.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import Soon.Coming.springbootdeveloper.user.domain.User;// 실제 사용자 정보로 교체 필요
import Soon.Coming.springbootdeveloper.postcool.domain.Post;
import Soon.Coming.springbootdeveloper.postcool.dto.AddPostRequest;
import Soon.Coming.springbootdeveloper.postcool.dto.UpdatePostRequest;
import Soon.Coming.springbootdeveloper.postcool.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // 게시물 생성
    public Post createPost(AddPostRequest request) {
        User user = new User(123L,"email", "username", "password"); // 실제 사용자 정보로 교체 필요
        Post post = request.toEntity(user);
        return postRepository.save(post);
    }

    // 모든 게시물 조회
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // 특정 게시물 조회
    public Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + postId));
    }

    // 게시물 삭제
    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }

    // 게시물 수정ㅇ
    @Transactional
    public Post update(Long postId, UpdatePostRequest request) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + postId));

        post.update(request.getTitle(), request.getContent());
        return post;
    }
}
