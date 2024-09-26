package soon.coming.springbootdeveloper.post.service;

import soon.coming.springbootdeveloper.post.domain.Post;
import soon.coming.springbootdeveloper.post.dto.AddPostRequest;
import soon.coming.springbootdeveloper.post.dto.UpdatePostRequest;
import soon.coming.springbootdeveloper.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    public Long save(AddPostRequest request) {
        Post post = postRepository.save(request.toEntity());
        return post.getId();
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public Post update(long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        post.update(request.getTitle(), request.getContent());
        return post;
    }
}

