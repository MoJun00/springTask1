package com.sparta.springtask1.service;

import com.sparta.springtask1.dto.ScheduleInfoDto;
import com.sparta.springtask1.dto.ScheduleRequestDto;
import com.sparta.springtask1.dto.ScheduleResponseDto;
import com.sparta.springtask1.entity.Schedule;
import com.sparta.springtask1.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j(topic = "DebugLog")
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        //log.info("Create schedule");
        Schedule schedule = scheduleRepository.save(new Schedule(requestDto));
        //log.info("Schedule 22");
        return new ScheduleResponseDto(schedule); // 저장된 일정 정보를 반환 받아 확인할 수 있습니다.
    }

    //선택한 스케쥴 가져오기
    public ScheduleResponseDto getSchedule(long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(()->new NullPointerException("존재 하지 않는 번호입니다!!"));
        log.info(schedule.getName());
        return new ScheduleResponseDto(schedule);
    }

    //모든 스케쥴 가져오기
    public List<ScheduleResponseDto> getSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        // ??? created_at 넣는거랑 무슨 차이인지 모르겠네 왜 에러뜨지
        List<ScheduleResponseDto> scheduleResponseDtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            scheduleResponseDtos.add(new ScheduleResponseDto(schedule));
        }
        return scheduleResponseDtos;
    }

    //업데이트
    @Transactional
    public ScheduleResponseDto updateSchedule(ScheduleRequestDto scheduleDto, long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(()->new NullPointerException("존재하지 않는 스케쥴입니다."));

        if(!schedule.getPwd().equals(scheduleDto.getPwd())) {
            try {
                throw new IllegalAccessException("비밀번호가 일치하지 않습니다.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        schedule.update(scheduleDto);

        return new ScheduleResponseDto(schedule); // ??? 수정한 날짜 즉시 변경된거 가져오고 싶은데
    }

    @Transactional
    public String deleteSchedule(ScheduleInfoDto scheduleInfoDto) {
        Schedule schedule = scheduleRepository.findById(scheduleInfoDto.getId()).orElseThrow(()->new NullPointerException("존재하지 않는 스케쥴입니다."));

        if(schedule.getPwd().equals(scheduleInfoDto.getPwd())) {
            scheduleRepository.delete(schedule);
            return "id : " + scheduleInfoDto.getId() + "   삭제 완료!!";
        }
        return "Error!! 비밀번호가 일치하지 않습니다. 삭제 실패!!";
    }
}
