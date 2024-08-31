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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //?????¤í?¸ì?? ??????ë¦?ì¼???´ì?? ì»??????¤í??
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper; //ì§???????, ??­ì????????

    @Autowired
    private WebApplicationContext context;

    @Autowired
    PostRepository postRepository;

    @BeforeEach //?????¤í?? ??¤í?? ??? ???????????? ??¤í??
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        postRepository.deleteAll();
    }

    @DisplayName("addArticle : ê¸? ì¶?ê°???? ??±ê³µ")
    @Test
    public void addArticle() throws Exception {
        //given
        final String url = "/posts";
        final String title = "title";
        final String content = "content";
    }
}