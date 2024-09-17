<<<<<<<< HEAD:src/main/java/Soon/Coming/springbootdeveloper/user/domain/User.java
package Soon.Coming.springbootdeveloper.user.domain;
========
package user.domain;
>>>>>>>> 5f49de1 (feat : post crud �???? (??????�?)):src/main/java/user/domain/User.java

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.*; // JPA �???? ??��?��????��????? ?????????
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity // JPA ?????��?��?? �????
public class User implements UserDetails {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId; //?????? ???�???? ID

    @Column(name = "email", nullable = false, unique = true)
    private String email; // ?????? ??��?????

    @Column(name = "username", nullable = false, unique = true)
    private String username; //?????? ?????��??

    @Column(name = "password", nullable = false)
    private String password; //?????? �?�?�????

    // �???? �????
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }


    // ???????????? username �???? (�??????? �?)
    @Override
    public String getUsername() {
        return username;
    }

    // ???????????? �?�?�???? �????
    @Override
    public String getPassword() {
        return password;
    }

    // �???? �?�? ???�? �????
    @Override
    public boolean isAccountNonExpired() {
        return true; // true -> �?�????�? ??????
    }

    // �???? ???�? ???�? �????
    @Override
    public boolean isAccountNonLocked() {
        return true; // true -> ???�????�? ??????
    }

    // ?????��????? �?�? ???�? �????
    @Override
    public boolean isCredentialsNonExpired() {
        return true; // true -> �?�????�? ??????
    }

    // �???? ?????? �???? ???�? �????
    @Override
    public boolean isEnabled() {
        return true; // true -> ?????? �????
    }
}