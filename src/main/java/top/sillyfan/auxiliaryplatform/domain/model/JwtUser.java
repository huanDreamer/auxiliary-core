package top.sillyfan.auxiliaryplatform.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import top.sillyfan.auxiliaryplatform.constants.AuthorityName;
import top.sillyfan.auxiliaryplatform.constants.UserDef;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JwtUser implements UserDetails {

    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private String email;

    private String qq;

    private String phone;

    private String mark;

    private Integer type;

    private Integer maxTokenNum;

    private Integer maxThreadNum;

    private Long superUser;

    private List<String> authorities;

    private Integer status;

    private Integer taskStatus;

    private Integer online;

    private DateTime lastPasswordResetDate;

    private DateTime expireDate;

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
        return UserDef.UserStatusEnum.Enabled.match(this.status)
                && (Objects.isNull(this.getExpireDate()) || this.getExpireDate().plusDays(1).isAfterNow());
    }

    @JsonIgnore
    public boolean isAdmin() {
        return UserDef.UserTypeEnum.Admin.match(this.type);
    }

    @JsonIgnore
    public boolean isSuperAuxiliary() {
        return UserDef.UserTypeEnum.Super_auxiliary.match(this.type);
    }

    @JsonIgnore
    public boolean isSecondAuxiliary() {
        return UserDef.UserTypeEnum.Second_auxiliary.match(this.type);
    }

    @JsonIgnore
    public boolean isAuxiliary() {
        return UserDef.UserTypeEnum.Auxiliary.match(this.type);
    }

    @JsonIgnore
    public boolean isDemander() {
        return UserDef.UserTypeEnum.Demander.match(this.type);
    }
}
