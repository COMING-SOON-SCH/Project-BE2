package Soon.Coming.springbootdeveloper.read.dto;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Post post){
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
