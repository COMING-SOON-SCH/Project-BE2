package Soon.Coming.springbootdeveloper.post.service;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import Soon.Coming.springbootdeveloper.post.dto.AddPostRequest;
import Soon.Coming.springbootdeveloper.post.dto.UpdatePostRequest;
import Soon.Coming.springbootdeveloper.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    //생성
    public Long save(AddPostRequest request) {
        Post post = postRepository.save(request.toEntity());
        return post.getId();
    }

    //전체 조회
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    //하나 조회
    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    //삭제
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    //수정
    @Transactional
    public Post update(long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        post.update(request.getTitle(), request.getContent());
        return post;
    }
}

