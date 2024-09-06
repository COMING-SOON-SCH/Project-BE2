package Soon.Coming.springbootdeveloper.post.dto;

import Soon.Coming.springbootdeveloper.domain.User;
import Soon.Coming.springbootdeveloper.post.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {

    @NotBlank
    @Size(min=1, max=5)
    private String title;
    private String content;

    @Positive
    private Long categoryId;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .user(new User(1L, "Ogu", "password"))
                .build();
    }
}