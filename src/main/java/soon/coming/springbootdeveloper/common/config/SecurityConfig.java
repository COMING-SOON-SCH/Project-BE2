package soon.coming.springbootdeveloper.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests((requests) -> requests
                        // Swagger 관련 URL 예외 처리
                        .requestMatchers("/","/api/v1/signup", "/api/v1/login",
                                "/swagger-resources/**", "/swagger-ui/**","/swagger-ui/index.html", "/v3/api-docs/**", "/api/v1/posts/**").permitAll()
                        // 나머지 요청은 인증 필요
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
