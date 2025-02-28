package com.example.miniproject.entity;

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
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*이미지 저장경로 유유아이디가 포함된 파일 이름*/
    private String imgName;

    /*이미지이름, 짱구*/
    private String oriImgName;

    private String imgUrl;
    /*이미지 경로*/

    private String isthumb;/*대표이미지 여부*/

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

}