package Soon.Coming.springbootdeveloper.post.dto;

import user.domain.User;
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
public class AddPostRequest {

    @NotBlank
    @Size(min=1, max=5)
    private String title;
    private String content;

    @NotBlank
    private Long user_id;

    @Positive
    private Long categoryId;

    public Post toEntity() {
        //???ì¤???? ??????
        User userExample = new User(1L, "Ogu", "password");
        return Post.builder()
                .title(title)
                .content(content)
                .user_id(user_id)
                //.user(userExample)
                .build();
    }
}