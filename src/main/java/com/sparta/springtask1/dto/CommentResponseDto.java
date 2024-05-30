package com.sparta.springtask1.dto;

import com.sparta.springtask1.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private Long id;
    private String content;
    private String userId;
    private Long scheduleId;
    private LocalDateTime createdAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userId = comment.getUserId();
        this.createdAt = comment.getCreatedAt();

        this.scheduleId = comment.getSchedule().getId();
    }
}
