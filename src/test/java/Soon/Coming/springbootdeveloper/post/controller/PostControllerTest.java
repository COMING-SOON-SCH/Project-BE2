package Soon.Coming.springbootdeveloper.post.controller;

import Soon.Coming.springbootdeveloper.post.repository.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest //?????��?��?? ??????�?�???��?? �??????��??
public class PostControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public ObjectMapper objectMapper; //�???????, ??��????????

    @Autowired
    private WebApplicationContext context;

    @Autowired
    PostRepository postRepository;

    @BeforeEach //?????��?? ??��?? ??? ???????????? ??��??
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        postRepository.deleteAll();
    }

    @DisplayName("Test about addArticle : �? �?�???? ??�공")
    @Test
    public void addArticle() throws Exception {
        //given
        final String url = "/posts";
        final String title = "title";
        final String content = "content";
    }
}