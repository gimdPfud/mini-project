package com.example.miniproject.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter @Setter
public class BaseTime {
    
    /*작성일자*/
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;
    
    /*수정일자*/
    @LastModifiedDate
    private LocalDateTime modDate;
}
