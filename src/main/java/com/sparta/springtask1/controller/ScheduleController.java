package com.sparta.springtask1.controller;

import com.sparta.springtask1.dto.ScheduleDto;
import com.sparta.springtask1.dto.ScheduleRequestDto;
import com.sparta.springtask1.dto.ScheduleResponseDto;
import com.sparta.springtask1.entity.Schedule;
import com.sparta.springtask1.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j(topic = "AuthFilter")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    private final Map<Integer, Schedule> schedules = new HashMap<Integer, Schedule>();

    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        log.info("hi " + requestDto.getName());
        return scheduleService.createSchedule(requestDto); // 나중에 유저 Id도?
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
                .append("Pwd : ").append(schedule.getPwd()).append("\n");
        }
        else
            sb.append("는 존재하지 않습니다.");

        return sb.toString();
    }

    /*
        body 부분
        주소에 id 넣고 body에 내용 넣었는데 잘못 만든거 같기도하고 body에 id까지 넣어야하나?
        //@RequestParam이랑 @RequestBody 랑 같이 쓸 수는 없는건가?
        { "title": "111","content": "222","name": "333","pwd": "4" }
     */
    @PutMapping("/updateSchedule/{id}")
    public String updateSchedule(@PathVariable int id, @RequestBody ScheduleRequestDto scheduleDto) {
        Schedule schedule = schedules.get(id);

        if(!schedule.getPwd().equals(scheduleDto.getPwd()))
            return "Error!! 비밀번호가 일치하지 않습니다. 업데이트 실패!!";

        schedule.setTitle(scheduleDto.getTitle());
        schedule.setContent(scheduleDto.getContent());
        schedule.setName(scheduleDto.getName());
        schedule.setPwd(scheduleDto.getPwd());
        return "id : " + id + "   업데이트 완료!!";
    }

    @DeleteMapping("/deleteSchedule/{id}/{pwd}")
    public String deleteSchedule(@PathVariable int id,@PathVariable String pwd) {
        Schedule schedule = schedules.get(id);

        if(!schedule.getPwd().equals(pwd))
            return "Error!! 비밀번호가 일치하지 않습니다. 삭제 실패!!";

        schedules.remove(id);

        return "id : " + id + "   삭제 완료!!";
    }
}
