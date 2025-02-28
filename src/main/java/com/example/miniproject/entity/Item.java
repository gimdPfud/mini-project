package com.example.miniproject.entity;

import com.example.miniproject.constant.ItemSellStatus;
import com.example.miniproject.constant.Season;
import com.example.miniproject.entity.base.BaseTimeBy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Item extends BaseTimeBy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;                //pk

    @Column(nullable = false)
    private String name;            //이름

    @Column(nullable = false)
    private int price;              //가격

    @Column(nullable = false)
    private String detail;          //상세설명

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ItemSellStatus itemSellStatus;  //판매상태

    private Long totalbuycount;     //상품주문횟수

    @Column(nullable = false)
    private int unit;               //판매단위

    @Column(nullable = false)
    private int shipcost;           //배송비

    /////////////////////////////////////////////

    private	String	color	;       //색상
    private	String	shape	;       //종류(발목 수면 발가락 스포츠)
    private	String	usefor	;       //착용대상
    private	String	texture	;       //소재
    private	String	pattern	;       //무늬 패턴

    @Enumerated(EnumType.STRING)
    Season season	;               //계절용(FW/SS)
}
