package Soon.Coming.springbootdeveloper.post.dto;

import lombok.Getter;
import Soon.Coming.springbootdeveloper.post.domain.Post;


@Getter
public class PostResponse {

    private Long id;
    private final String title;
    private final String content;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}