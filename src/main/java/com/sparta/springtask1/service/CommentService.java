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

@Service
@RequiredArgsConstructor
@Slf4j(topic = "DebugLog")
public class CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto) {

        Schedule schedule = scheduleRepository.findById(commentRequestDto.getSchedule_id()).orElseThrow(()->new NullPointerException("존재 하지 않는 스케쥴 ID"));

        Comment comment = commentRepository.save(new Comment(commentRequestDto,schedule));

        return new CommentResponseDto(comment);
    }
}
