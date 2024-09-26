package Soon.Coming.springbootdeveloper.post.service;

import Soon.Coming.springbootdeveloper.post.domain.Post;
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

    public Post createPost(CreatePostRequest createPostRequest) {
       return postRepository.save(createPostRequest.toEntity());
    }


    public List<Post> findAll(){
        return postRepository.findAll();
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

