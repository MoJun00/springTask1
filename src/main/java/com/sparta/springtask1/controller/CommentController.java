package com.sparta.springtask1.controller;

import com.sparta.springtask1.dto.CommentRequestDto;
import com.sparta.springtask1.dto.CommentResponseDto;
import com.sparta.springtask1.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j(topic = "AuthFilter")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment")
    public CommentResponseDto createComment(@RequestBody @Valid CommentRequestDto commentRequestDto) {

        CommentResponseDto commentResponseDto = commentService.createComment(commentRequestDto);
        log.info("id : "+commentResponseDto.getId());
        return commentResponseDto;
    }
}
