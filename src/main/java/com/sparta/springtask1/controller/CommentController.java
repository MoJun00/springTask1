package com.sparta.springtask1.controller;

import com.sparta.springtask1.dto.CommentRequestDelDto;
import com.sparta.springtask1.dto.CommentRequestDto;
import com.sparta.springtask1.dto.CommentResponseDto;
import com.sparta.springtask1.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j(topic = "AuthFilter")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/comment")
    public CommentResponseDto createComment(@RequestBody @Valid CommentRequestDto requestDto) {

        CommentResponseDto commentResponseDto = commentService.createComment(requestDto);
        log.info("id : "+commentResponseDto.getId());
        return commentResponseDto;
    }

    @PutMapping("/comment/{id}")
    public CommentResponseDto updateComment(@PathVariable("id") Long id, @RequestBody @Valid CommentRequestDto requestDto) {
        return commentService.updateComment(id,requestDto);
    }

    @DeleteMapping("comment/{id}")
    public String deleteComment(@PathVariable("id") Long id, @RequestBody @Valid CommentRequestDelDto requestDto) {
        return commentService.deleteComment(id,requestDto);
    }
}
