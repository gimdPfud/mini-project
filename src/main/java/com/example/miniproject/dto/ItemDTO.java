package com.example.miniproject.dto;

import com.example.miniproject.constant.ItemSellStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemDTO {

    private Long id;                //pk
    private String name;            //이름
    private int price;              //가격
    private String detail;          //상세설명
    private int unit;               //판매단위
    private int shipcost;           //배송비

    private	String	color	;       //색상
    private	String	shape	;       //종류(발목 수면 발가락 스포츠)
    private	String	usefor	;       //착용대상
    private	String	texture	;       //소재
    private	String	pattern	;       //무늬 패턴
    private String  season	;       //계절용(FW/SS)

    private ItemSellStatus itemSellStatus;  //판매상태

    private List<ImageDTO> imageDTOList;

    public ItemDTO setImageDTOList(List<ImageDTO> imageDTOList) {
        this.imageDTOList = imageDTOList;
        return this;
    }
}