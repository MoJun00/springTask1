package com.sparta.springtask1.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDelDto {
    @NotEmpty(message = "유저 ID가 비어있음")
    private String userId;

    @NotNull(message = "일정의 id를 입력 받지 않음")
    private Long schedule_id;
}
