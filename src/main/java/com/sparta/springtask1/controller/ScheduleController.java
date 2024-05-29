package com.sparta.springtask1.controller;

import com.sparta.springtask1.dto.ScheduleInfoDto;
import com.sparta.springtask1.dto.ScheduleRequestDto;
import com.sparta.springtask1.dto.ScheduleResponseDto;
import com.sparta.springtask1.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j(topic = "AuthFilter")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        log.info("hi " + requestDto.getName());
        return scheduleService.createSchedule(requestDto); // 나중에 유저 Id도?
    }

    @GetMapping("/schedule/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable long id) {
        return scheduleService.getSchedule(id);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> selectSchedule() {
        return scheduleService.getSchedules();
    }

    //   { "title": "111","content": "222","name": "333","pwd": "4" }

    @PutMapping("/schedule/{id}")
    public ScheduleResponseDto updateSchedule(@RequestBody ScheduleRequestDto scheduleDto,@PathVariable long id) {
        return scheduleService.updateSchedule(scheduleDto,id);
    }

    @DeleteMapping("/schedule")
    public String deleteSchedule(@RequestBody ScheduleInfoDto scheduleInfoDto) {
        return scheduleService.deleteSchedule(scheduleInfoDto);
    }
}
