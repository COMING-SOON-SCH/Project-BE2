package Soon.Coming.springbootdeveloper.user.controller;

import Soon.Coming.springbootdeveloper.user.dto.AddUserRequest;
import Soon.Coming.springbootdeveloper.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/auth")
public class UserApicontroller {

    private final UserService userService;

    /** 회원가입 컨트롤러 메서드. 완료 후 로그인 페이지로 연결됨*/
    @PostMapping("/signup")
    public String signup(AddUserRequest request){
        userService.save(request) ;//회원가입 메서드 호출
        return "redirect:/api/v1/auth/login"; //회원가입 완료 이후 로그인 페이지로 이동
    }
    
    /** 로그아웃 컨트롤러 메서드. 완료 후 로그인 페이지로 연결됨*/
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/api/v1/auth/login";
    }
}
