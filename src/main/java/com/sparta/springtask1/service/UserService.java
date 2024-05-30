package com.sparta.springtask1.service;

import com.sparta.springtask1.dto.UserRequestDto;
import com.sparta.springtask1.entity.User;
import com.sparta.springtask1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String createUser(UserRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername());

        if (user == null) {
            userRepository.save(new User(requestDto));
            return "생성 완료";
        }
        System.out.println(user.toString());
        return "중복된 UserName 입니다.";
    }
}
