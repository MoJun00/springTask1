package com.sparta.springtask1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {
    @CreatedDate  // 최초 생성시 시간
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @LastModifiedDate // 변경할 때 자동으로 갱신됨
    @Column
    @Temporal(TemporalType.TIMESTAMP) // DATE : 2020-2-2, TIME : 11:11:11, TIMESTAMP : 2020-2-2 11:11:11.1111
    private LocalDateTime modifiedAt;
}
