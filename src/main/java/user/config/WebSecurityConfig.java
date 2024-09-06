package Soon.Coming.springbootdeveloper.config;

import Soon.Coming.springbootdeveloper.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserDetailService userService;

    @Bean
    // 1. ??��??�? ??????�???? 기�?? �??????��??
    public WebSecurityCustomizer configure(){
        return(web -> web.ignoring()
                .requestMatchers(toH2Console())
                .requestMatchers(new AntPathRequestMatcher("/static/**"))
        );
    }

    /**2. ??��?? HTTP ???청�?? ?????? ??? 기�?? 보�?? �???? */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth-> auth
                        .requestMatchers(
                                new AntPathRequestMatcher("/login"),
                                new AntPathRequestMatcher("/signup"),
                                new AntPathRequestMatcher("/user")
                        ).permitAll()
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/articles")
                )
                .logout(logout -> logout //�?그�????? ??��??
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                )
                .csrf(AbstractHttpConfigurer::disable) //csrf �??????��??
                .build();
    }

    /** ??��?? �?�???? �???? ??��?? */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
                                                       BCryptPasswordEncoder bCryptpasswordEncoder,
                                                       UserDetailService userDetailService)
            throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService); //????????? ???�? ???�???? ??��??
        authProvider.setPasswordEncoder(bCryptpasswordEncoder);
        return new ProviderManager(authProvider);
    }

    /** ?????��????? ??��?????�? ????????? �? ??��?????�?*/
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}