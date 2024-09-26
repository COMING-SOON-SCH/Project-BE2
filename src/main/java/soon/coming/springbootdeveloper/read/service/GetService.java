package soon.coming.springbootdeveloper.read.service;

import soon.coming.springbootdeveloper.post.domain.Post;
import soon.coming.springbootdeveloper.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetService {
    private final PostRepository postRepository;

    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
