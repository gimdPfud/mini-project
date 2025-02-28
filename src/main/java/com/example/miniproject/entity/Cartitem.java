package com.example.miniproject.entity;

import com.example.miniproject.constant.CartStatus;
import com.example.miniproject.entity.base.BaseTimeBy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString @NoArgsConstructor
public class Cartitem extends BaseTimeBy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartitem_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;    //어떤건지?

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private int itemamount; //상품 개수

    @Enumerated(value = EnumType.STRING)
    CartStatus cartStatus; /*wish(구매 전) end(구매 후)*/
}
