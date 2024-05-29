package com.sparta.springtask1.entity;

import com.sparta.springtask1.dto.ScheduleDto;
import com.sparta.springtask1.dto.ScheduleRequestDto;
import com.sparta.springtask1.dto.ScheduleResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Schedule extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유 Id

    @Column (nullable = false)
    private String title; // 할일 제목

    @Column (nullable = false)
    private String content; // 할일 내용

    @Column (nullable = false)
    private String name; // 담당자

    @Column (nullable = false)
    private String pwd; // 비밀번호
    
    public Schedule(ScheduleRequestDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.name = dto.getName();
        this.pwd = dto.getPwd();
    }
}
