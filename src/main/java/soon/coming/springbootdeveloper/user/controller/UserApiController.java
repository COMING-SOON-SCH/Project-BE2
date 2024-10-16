package soon.coming.springbootdeveloper.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestBody;
import soon.coming.springbootdeveloper.user.domain.User;
import soon.coming.springbootdeveloper.user.dto.AddUserRequest;
import soon.coming.springbootdeveloper.user.service.UserService;
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
@Tag(name = "User", description = "User API")
public class UserApiController {

    private final UserService userService;

    /** 회원가입 컨트롤러 메서드. 완료 후 로그인 페이지로 연결됨*/
    @PostMapping("/signup")
    @Operation(summary = "Execute signup", description = "회원가입을 진행합니다")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "200", description = "회원가입 성공",
        content = {@Content(schema = @Schema(implementation = User.class))}),
        @ApiResponse(responseCode = "403", description = "입력값이 잘못되었습니다")
    })
    public String signup(@RequestBody AddUserRequest request){
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
