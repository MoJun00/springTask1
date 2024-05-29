package com.sparta.springtask1.dto;

import com.sparta.springtask1.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Slf4j(topic = "DebugLog")
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String content;
    private String name;
    private String pwd;
    private LocalDateTime modifiedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.name = schedule.getName();
        this.pwd = schedule.getPwd();
        this.modifiedAt = schedule.getModifiedAt();
        log.info("? : " + schedule.getModifiedAt());
    }
}
