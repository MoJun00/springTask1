package com.sparta.springtask1.dto;

import com.sparta.springtask1.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleDto {
    private int id;
    private String title;
    private String content;
    private String name;
    private String pwd;
    private LocalDateTime date;

    public ScheduleDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.name = schedule.getName();
        this.pwd = schedule.getPwd();
        this.date = schedule.getDate();
    }
}
