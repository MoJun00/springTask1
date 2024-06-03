package com.sparta.springtask1.service;

import com.sparta.springtask1.dto.UserRequestDto;
import com.sparta.springtask1.entity.User;
import com.sparta.springtask1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String createUser(UserRequestDto requestDto) {
        Optional<User> user = userRepository.findByUsername(requestDto.getUsername());

        if (user.isPresent()) {
            return "중복된 UserName 입니다.";
        }
        String password = passwordEncoder.encode(requestDto.getPassword());
        userRepository.save(new User(requestDto.getNickname(),requestDto.getUsername(),password,requestDto.getRole()));
        //pwd 암호화o

        //userRepository.save(new User(requestDto));
        //pwd 암호화x

        //System.out.println(user.toString());
        return "생성 완료";
    }
}
