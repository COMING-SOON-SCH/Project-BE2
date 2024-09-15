package Soon.Coming.springbootdeveloper.post.dto;

import Soon.Coming.springbootdeveloper.user.domain.User;
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

    @NotBlank
    private Long user_id;

    @NotBlank
    private String email;

    @Positive
    private Long categoryId;



    public Post toEntity() {
        //나중에 수정
        User userExample = new User();
        return Post.builder()
                .title(title)
                .content(content)
                .user_id(user_id)

                .build();
    }
}
