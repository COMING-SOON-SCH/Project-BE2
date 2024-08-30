package Soon.Coming.springbootdeveloper.post_crud.dto;

import Soon.Coming.springbootdeveloper.post_crud.domain.Article;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    @NotBlank
    @Size(min=1, max=5)
    private String title;
    private String content;
    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
