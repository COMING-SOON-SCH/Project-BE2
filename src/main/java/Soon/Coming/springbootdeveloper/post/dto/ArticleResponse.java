package Soon.Coming.springbootdeveloper.post.dto;

import lombok.Getter;
import Soon.Coming.springbootdeveloper.post.domain.Article;


@Getter
public class ArticleResponse {

    private final String title;
    private final String content;
    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
