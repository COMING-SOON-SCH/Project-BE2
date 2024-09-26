package Soon.Coming.springbootdeveloper.postcool.dto;

import Soon.Coming.springbootdeveloper.postcool.domain.Post;
import lombok.Getter;

@Getter
public class PostResponse {

    private final String title;
    private final String content;

    public PostResponse(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
