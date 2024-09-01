package Soon.Coming.springbootdeveloper.post.domain;

import Soon.Coming.springbootdeveloper.common.entity.BaseEntity;
import Soon.Coming.springbootdeveloper.userSignup.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    /*
    @ManyToOne(fetch = FetchType.LAZY) //????????? ê´???? ???ë³´ë¥¼ postê°? ????????? ???ë§? ê°???¸ì?¤ê?? ???
    @JoinColumn(name = "user_id")
    private User user;
    */

}
