package com.romani.nozol.config.security;

import com.romani.nozol.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private String email;
    private String password;
    private int enabled;
    private String type;

    public MyUserDetails() {
    }

    public MyUserDetails(User user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.enabled = user.getEnabled();
        this.type = user.getUserType().getUserType();
    }

    public MyUserDetails(String email) {
        this.email = email;
    }

    public MyUserDetails(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(type));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
        if (enabled == 0){
            return false;
        }
        return true;
    }

}
