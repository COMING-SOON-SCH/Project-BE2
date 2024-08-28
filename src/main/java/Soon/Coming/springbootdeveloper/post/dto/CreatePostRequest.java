package Soon.Coming.springbootdeveloper.post.dto;

import Soon.Coming.springbootdeveloper.domain.User;
import Soon.Coming.springbootdeveloper.post.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostRequest {

    @NotBlank
    private String title;

    @NotBlank
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
