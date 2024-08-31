package Soon.Coming.springbootdeveloper.post.dto;


import Soon.Coming.springbootdeveloper.domain.User;
import Soon.Coming.springbootdeveloper.post.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePostRequest {

    private String title;

    private String content;

    private Long categoryId;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .user(new User(1L, "User1", "password"))
                .build();
    }
}
