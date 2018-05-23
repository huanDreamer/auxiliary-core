package top.sillyfan.auxiliaryplatform.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import top.sillyfan.auxiliaryplatform.constants.AuthorityName;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtUser implements UserDetails {

    private String id;

    private String username;

    @JsonIgnore
    private String password;

    private String email;

    private List<String> authorities;

    private boolean enabled;

    private Date lastPasswordResetDate;

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (CollectionUtils.isEmpty(authorities)) {
            return Collections.singletonList(new SimpleGrantedAuthority(AuthorityName.ROLE_USER));
        }
        List<SimpleGrantedAuthority> auths = authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());

        auths.add(new SimpleGrantedAuthority(AuthorityName.ROLE_USER));

        return auths;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
