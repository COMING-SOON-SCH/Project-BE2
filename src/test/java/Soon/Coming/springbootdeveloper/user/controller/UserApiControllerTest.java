package Soon.Coming.springbootdeveloper.user.controller;


import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import Soon.Coming.springbootdeveloper.user.dto.AddUserRequest;
import Soon.Coming.springbootdeveloper.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserApiController.class) // 컨트롤러 레이어 테스트
class UserApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("회원가입 성공 테스트")
    void testSignup() throws Exception {
        AddUserRequest request = new AddUserRequest();
        request.setUserId(1L);
        request.setEmail("test@example.com");
        request.setUsername("testuser");
        request.setPassword("password");

        // userService.save()가 호출되면 아무 일도 하지 않도록 목 설정
        Mockito.when(userService.save(any(AddUserRequest.class))).thenReturn(null);

        mockMvc.perform(post("/api/v1/auth/signup")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("userId", "1")
                        .param("email", "test@example.com")
                        .param("username", "testuser")
                        .param("password", "password"))
                .andExpect(status().is3xxRedirection())  // 리다이렉트 확인
                .andExpect(redirectedUrl("/api/v1/auth/login")); // 로그인 페이지로 리다이렉트 확인
    }

    @Test
    @DisplayName("로그아웃 성공 테스트")
    void testLogout() throws Exception {
        mockMvc.perform(get("/api/v1/auth/logout"))
                .andExpect(status().is3xxRedirection())  // 리다이렉트 확인
                .andExpect(redirectedUrl("/api/v1/auth/login")); // 로그인 페이지로 리다이렉트 확인
    }

}