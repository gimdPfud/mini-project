package com.example.miniproject.entity;

import com.example.myproject.entity.base.BaseTimeBy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Question extends BaseTimeBy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long id;

    @Column(nullable = false)
    private String content;     //문의 내용

    @Column(nullable = false)
    private String title;       //문의 제목

    @Column(nullable = false)
    @ColumnDefault("false")
    private boolean isreplied;  //문의는 답변 되었나요?

}
