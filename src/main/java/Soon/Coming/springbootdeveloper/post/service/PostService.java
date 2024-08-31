package Soon.Coming.springbootdeveloper.post.service;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import Soon.Coming.springbootdeveloper.post.dto.AddPostRequest;
import Soon.Coming.springbootdeveloper.post.dto.UpdatePostRequest;
import Soon.Coming.springbootdeveloper.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(CreatePostRequest createPostRequest) {
       return postRepository.save(createPostRequest.toEntity());
    }

    /** ??°ì?´í?°ë????´ì?¤ì?? ?????¥ë????? ?????? ê¸???? ëª???? ê°???¸ì?¤ê?? ???*/
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    //??­ì??
    public void delete(long id) {
        postRepository.deleteById(id);
    }

    //??????
    @Transactional
    public Post update(long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        post.update(request.getTitle(), request.getContent());
        return post;
    }
}

