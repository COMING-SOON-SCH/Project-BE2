package soon.coming.springbootdeveloper.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UserTable") //user는 SQL 예약어. 이름변경
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userCode", nullable = false, unique = true)
    private Long userCode;

    //email -> 일반 ID로 바꾸기
    @Column(name = "userID", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true; // true -> 留?猷????吏? ??????
    }


    @Override
    public boolean isAccountNonLocked() {
        return true; // true -> ???湲????吏? ??????
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true; // true -> 留?猷????吏? ??????
    }


    @Override
    public boolean isEnabled() {
        return true; // true -> ?????? 媛????
    }
}