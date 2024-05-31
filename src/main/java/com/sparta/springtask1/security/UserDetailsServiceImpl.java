package com.sparta.springtask1.security;

import com.sparta.springtask1.entity.User;
import com.sparta.springtask1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j(topic = "UserDetails Service Impl")
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("test " + username);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found " + username));

        log.info("??? user.username : " + user.getUsername());
        log.info("??? user.pwd : " + user.getPassword());

        return new UserDetailsImpl(user);
    }
}
