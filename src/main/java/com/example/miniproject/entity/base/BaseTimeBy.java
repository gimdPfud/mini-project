package com.example.miniproject.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
@Getter @Setter
public class BaseTimeBy extends BaseTime {

    /*작성자*/
    @CreatedBy
    @Column(updatable = false)
    private String createBy;

    /*수정자*/
    @LastModifiedBy
    private String modifiedBy;

    /*작성일자와 수정일자 extends*/
}
