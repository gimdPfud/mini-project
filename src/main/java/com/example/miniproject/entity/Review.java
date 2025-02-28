package com.example.miniproject.entity;

import com.example.myproject.entity.base.BaseTimeBy;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Review extends BaseTimeBy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    private String content; //리뷰 내용

    @Column(nullable = false)
    @Size(min = 0, max = 5, message = "별점은 0점에서 5점 사이만 가능합니다.")
    private int score;      //리뷰 별점

    @OneToOne
    @JoinColumn(name = "orders_id", unique = true, nullable = false)
    private Orders orders;  //리뷰할라면 주문번호 있어야되니까...
    
}
