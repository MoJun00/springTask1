package com.sparta.springtask1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@Getter
@Slf4j(topic = "DebugLog")
public class ScheduleRequestDto {
    private String title;
    private String content;
    private String name;
    private String pwd;

    public ScheduleRequestDto(String title, String content, String name, String pwd) {
        log.info("Create ScheduleRequestDto");
        this.title = title;
        this.content = content;
        this.name = name;
        this.pwd = pwd;
    }
}
