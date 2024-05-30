package com.sparta.springtask1.service;

import com.sparta.springtask1.dto.CommentRequestDto;
import com.sparta.springtask1.dto.CommentResponseDto;
import com.sparta.springtask1.entity.Comment;
import com.sparta.springtask1.entity.Schedule;
import com.sparta.springtask1.repository.CommentRepository;
import com.sparta.springtask1.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "DebugLog")
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto createComment(CommentRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findById(requestDto.getSchedule_id()).orElseThrow(()->new NullPointerException("존재 하지 않는 스케쥴 ID"));

        Comment comment = commentRepository.save(new Comment(requestDto,schedule));

        return new CommentResponseDto(comment);
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findById(requestDto.getSchedule_id()).orElseThrow(()->new NullPointerException("존재 하지 않는 스케쥴 ID"));

        Comment comment = commentRepository.findById(id).orElseThrow(()->new NullPointerException("존재 하지 않는 댓글 ID"));

        if(!comment.getUserId().equals(requestDto.getUserId())){
            try {
                throw new IllegalAccessException("선택한 댓글 사용자가 현재 사용자와 일치하지 않습니다");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        comment.updateContent(requestDto.getContent());

        return new CommentResponseDto(comment);
    }
}
