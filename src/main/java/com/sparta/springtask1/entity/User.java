package com.sparta.springtask1.entity;

import com.sparta.springtask1.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@ToString
public class User extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 아이디

    @Column(nullable = false)
    private String nickname; // 별명

    @Column(nullable = false)
    private String username; // 사용자 이름

    @Column(nullable = false)
    private String password; // 비밀번호

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role; //권한

    public User(UserRequestDto requestDto) {
        nickname = requestDto.getNickname();
        username = requestDto.getUsername();
        password = requestDto.getPassword();
        role = requestDto.getRole();
    }
}
