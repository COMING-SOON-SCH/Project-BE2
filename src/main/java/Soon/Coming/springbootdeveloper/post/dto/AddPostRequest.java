package Soon.Coming.springbootdeveloper.post.dto;

import Soon.Coming.springbootdeveloper.userSignup.domain.User;
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
        //???ì¤???? ??????
        User userExample = new User(1L, "Ogu", "password");
        return Post.builder()
                .title(title)
                .content(content)
                .user(new User(1L, "Ogu", "password"))
                .build();
    }
}