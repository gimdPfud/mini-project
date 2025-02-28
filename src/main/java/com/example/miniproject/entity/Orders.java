package com.example.miniproject.entity;

import com.example.miniproject.constant.Ostatus;
import com.example.miniproject.entity.base.BaseTimeBy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Orders extends BaseTimeBy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(unique = true)
    private String orderscode;  //주문번호

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Ostatus ostatus;            //주문 상태
}
