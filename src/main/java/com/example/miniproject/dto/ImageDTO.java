package com.example.miniproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ImageDTO {
    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String isthumb;
    private ItemDTO itemDTO;
    private ReviewDTO reviewDTO;
    private QuestionDTO questionDTO;
}
