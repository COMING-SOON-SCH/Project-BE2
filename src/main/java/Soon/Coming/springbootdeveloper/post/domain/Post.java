package Soon.Coming.springbootdeveloper.post.domain;

import Soon.Coming.springbootdeveloper.domain.User;
import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 1씩 증가
    private Long postId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) //유저에 관한 정보를 post가 필요할 때만 가져오게 함
    @JoinColumn(name = "user_id")
    private User user;
}
