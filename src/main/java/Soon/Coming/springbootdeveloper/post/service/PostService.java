package Soon.Coming.springbootdeveloper.post.service;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import Soon.Coming.springbootdeveloper.post.dto.CreatePostRequest;
import Soon.Coming.springbootdeveloper.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public Post createPost(CreatePostRequest createPostRequest) {
       return postRepository.save(createPostRequest.toEntity());
    }

    /** 데이터베이스에 저장되어 있는 글을 모두 가져오게 함*/
    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
