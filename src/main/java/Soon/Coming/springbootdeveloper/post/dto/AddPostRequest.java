package Soon.Coming.springbootdeveloper.post.dto;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddPostRequest {

    @NotBlank
    @Size(min=1, max=5)
    private String title;
    private String content;
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}