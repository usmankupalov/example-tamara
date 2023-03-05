package com.example.shopinternet.security;

import com.example.shopinternet.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private Integer userId;
    private String phoneNumber;
    private String password;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public UserDetailsImpl(Integer userId, String phoneNumber, String password, Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
    }

    public static UserDetailsImpl fromUserEntityToCustomUserDetails (User user) {
        List<GrantedAuthority> authorities = user.getUserRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
        return new UserDetailsImpl(user.getUserId(), user.getPhoneNumber(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetailsImpl)) return false;
        UserDetailsImpl that = (UserDetailsImpl) o;
        return Objects.equals(userId, that.userId) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(password, that.password) && Objects.equals(grantedAuthorities, that.grantedAuthorities);
    }
}
