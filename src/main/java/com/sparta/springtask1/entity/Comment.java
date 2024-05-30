package com.sparta.springtask1.entity;

import com.sparta.springtask1.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 아이디 (고유번호)

    @Column (nullable = false)
    private String content; // 댓글 내용

    @Column (nullable = false)
    private String userId;
    //@Column (nullable = false)
    //private Long scheduleId; // 일정 아이디 (고유번호)

    // 일정 하나에 여러개의 댓글이 가능 ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(CommentRequestDto requestDto, Schedule schedule) {
        this.content = requestDto.getContent();
        this.userId = requestDto.getUserId();
        this.schedule = schedule;
    }

    public void updateContent(String content)
    {
        this.content = content;
    }
}
