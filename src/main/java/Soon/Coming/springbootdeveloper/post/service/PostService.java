package Soon.Coming.springbootdeveloper.post.service;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import Soon.Coming.springbootdeveloper.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostSerive {

    private final PostRepository postRepository;

    public Post save(AddPostRequest request) {
        return PostRepository.save(request.toEntity());
    }

    public List<Post> findAll() {
        return PostRepository.findAll();
    }

    public Post findById(long id) {
        return PostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    public void delete(long id) {
        PostRepository.deleteById(id);
    }

    public Post update(long id, UdatePostRequest request) {
        Post post = PostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));

        post.update(request.getTitle(), request.getContent());

        return post;
    }
}