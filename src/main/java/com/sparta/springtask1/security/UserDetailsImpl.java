package com.sparta.springtask1.security;

import com.sparta.springtask1.entity.User;
import com.sparta.springtask1.entity.UserRoleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j(topic = "UserDetails Impl")
public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
        log.info("UserDetailsImpl created");
    }
    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("??");
        UserRoleEnum role = user.getRole();
        String authority = role.getAuthority();

        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(simpleGrantedAuthority);

        return authorities;
    }

    @Override
    public String getPassword() {
        log.info("mmm");
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
