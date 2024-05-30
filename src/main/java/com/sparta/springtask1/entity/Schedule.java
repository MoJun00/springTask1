package com.sparta.springtask1.entity;

import com.sparta.springtask1.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schedule")
@Getter
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

    @OneToMany(mappedBy = "schedule",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
    
    public Schedule(ScheduleRequestDto dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.name = dto.getName();
        this.pwd = dto.getPwd();
    }

    public void update(ScheduleRequestDto scheduleDto) {
        this.title = scheduleDto.getTitle();
        this.content = scheduleDto.getContent();
        this.name = scheduleDto.getName();
    }
}
