package com.sparta.springtask1.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private String title;
    private String content;
    private String name;
    private String pwd;
    private LocalDateTime date;
}