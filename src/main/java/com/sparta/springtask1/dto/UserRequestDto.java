package com.sparta.springtask1.dto;

import com.sparta.springtask1.entity.UserRoleEnum;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {

    private String nickname; // 별명

    @Size(min = 4, max = 10, message = "최소 4자 이상, 10자 이하로 입력해 주세요")
    @Pattern(regexp = "^[a-z0-9]+$", message = "소문자 a~z , 숫자 0~9 로 입력해 주세요")
    private String username; // 사용자 이름

    @Size(min = 8, max = 15, message = "최소 8자 이상, 15자 이하로 입력해 주세요")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "소문자 a~z , 숫자 0~9 로 입력해 주세요")
    private String password; // 비밀번호

    private UserRoleEnum role; //권한
}
