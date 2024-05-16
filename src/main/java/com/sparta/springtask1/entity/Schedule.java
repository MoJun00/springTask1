package com.sparta.springtask1.entity;

import com.sparta.springtask1.dto.ScheduleDto;
import com.sparta.springtask1.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor

public class Schedule {
    private int id;
    private String title;
    private String content;
    private String name;
    private String pwd;
    private LocalDateTime date;
    
    public Schedule(ScheduleRequestDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.name = dto.getName();
        this.pwd = dto.getPwd();
        date = dto.getDate();
    }

    public void update(ScheduleDto dto) {
        this.content = dto.getContent();
    }

}
