package Soon.Coming.springbootdeveloper.user.domain;

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
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;

    @Column(name = "email", nullable = false, unique = true)
    private String email; // ?????? ??대?????

    @Column(name = "username", nullable = false, unique = true)
    private String username; //?????? ?????ㅼ??

    @Column(name = "password", nullable = false)
    private String password; //?????? 鍮?諛?踰????\
    
    /*@Column(nullable = false)
    private String name;
    */


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