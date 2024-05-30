package com.sparta.springtask1.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequestDto {
    @NotEmpty(message = "댓글 내용이 비어있음")
    private String comment;
    private String userId;

    @NotNull(message = "일정의 id를 입력 받지 않음")
    private Long schedule_id;
}
