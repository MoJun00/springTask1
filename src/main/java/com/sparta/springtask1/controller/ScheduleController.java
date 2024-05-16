package com.sparta.springtask1.controller;

import com.sparta.springtask1.dto.ScheduleDto;
import com.sparta.springtask1.dto.ScheduleRequestDto;
import com.sparta.springtask1.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final Map<Integer, Schedule> schedules = new HashMap<Integer, Schedule>();

    @PostMapping("/saveSchedule")
    public ScheduleDto save(@RequestBody ScheduleRequestDto scheduleDto) {
        Schedule schedule = new Schedule(scheduleDto);

        int id = schedules.size()+1;
        schedule.setId(id);
        schedule.setDate(LocalDateTime.now());
        schedules.put(id,schedule);

        ScheduleDto savedDto = new ScheduleDto(schedule);
        return savedDto; // 저장된 일정 정보를 반환 받아 확인할 수 있습니다.
    }

    @GetMapping("/loadSchedules")
    public List<ScheduleDto> loadSchedule() {
        List<ScheduleDto> scheduleDtos = new ArrayList<ScheduleDto>();
        //오름 차순 내림차순 정렬 날짜 기준으로 나중에 필요하면 만들기?
        //https://m.blog.naver.com/ljn425/221308453387
        for (Map.Entry<Integer, Schedule> entry : schedules.entrySet()) {
            ScheduleDto scheduleDto = new ScheduleDto(entry.getValue());
            scheduleDtos.add(scheduleDto);
        }
        return scheduleDtos;
    }

    @GetMapping("/selectSchedule/{id}")
    public String selectSchedule(@PathVariable int id) {
        StringBuilder sb = new StringBuilder();

        Schedule schedule = schedules.get(id);
        sb.append("선택한 id : ").append(id).append("\n");
        if (schedule != null) {
            sb.append("Title : ").append(schedule.getTitle()).append("\n")
                .append("Content : ").append(schedule.getContent()).append("\n")
                .append("Name : ").append(schedule.getName()).append("\n")
                .append("Pwd : ").append(schedule.getPwd()).append("\n")
                .append("Date : ").append(schedule.getDate()).append("\n");
        }
        else
            sb.append("는 존재하지 않습니다.");

        return sb.toString();
    }
}
