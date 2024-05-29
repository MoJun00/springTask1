package com.sparta.springtask1.service;

import com.sparta.springtask1.dto.ScheduleRequestDto;
import com.sparta.springtask1.dto.ScheduleResponseDto;
import com.sparta.springtask1.entity.Schedule;
import com.sparta.springtask1.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "AuthFilter")
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        log.info("Create schedule");
        Schedule schedule = scheduleRepository.save(new Schedule(requestDto));
        log.info("Schedule 22");
        return new ScheduleResponseDto(schedule); // 저장된 일정 정보를 반환 받아 확인할 수 있습니다.
    }
}
