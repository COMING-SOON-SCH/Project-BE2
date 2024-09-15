package Soon.Coming.springbootdeveloper.post.controller;

import Soon.Coming.springbootdeveloper.post.domain.Post;
import Soon.Coming.springbootdeveloper.post.dto.CreatePostRequest;
import Soon.Coming.springbootdeveloper.post.repository.PostRepository;
import Soon.Coming.springbootdeveloper.user.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//아니 30분전까진 잘됐잖아 기본 테스트 설정을 Gradle->InteliJ로 바꾸면 되는데 아니 근데 왜 안되
//넌 항상 그런식이야
@AutoConfigureMockMvc
@SpringBootTest //테스트용 애플리케이션 컨텍스트
public class PostControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public ObjectMapper objectMapper; //직렬화, 역직렬화

    @Autowired
    private WebApplicationContext context;

    @Autowired
    PostRepository postRepository;

    @BeforeEach //테스트 실행 전 하나하나 실행
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        postRepository.deleteAll();
    }

    @DisplayName("Test about addArticle : 글 추가에 성공")
    @Test
    public void addArticle() throws Exception {
        //given
        final String url = "/posts";
        final String title = "title";
        final String content = "content";
        final Long categoryId = 1L;
        final User user = new User();
        final CreatePostRequest createPostRequest = new CreatePostRequest(title, content, categoryId);

        //객체 JSON으로 직렬화
        final String requestBody = objectMapper.writeValueAsString(createPostRequest);

        //when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestBody)
        );

        //then
        result.andExpect(status().isCreated());

        List<Post> posts = postRepository.findAll();

        assertThat(posts.size()).isEqualTo(1);
        assertThat(posts.get(0).getTitle()).isEqualTo(title);
        assertThat(posts.get(0).getContent()).isEqualTo(content);
    }
}