package com.example.miniproject.repository;

import com.example.miniproject.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemSearch {
    /*todo 너무 어려워서 일단 보류!!!
    *
    * 그냥 메인리스트에서 뽑아올거.
    * 숍에서는 메인페이지에 그냥 다 보여줬음.. (근데 그럼 왜 키워드를 뽑은거지 ?? )
    * 필요한거
    * 카테고리에 따라 리스트 보여주기 <--이게 문제....... 두개를 보내고/받고 해야하나?
    * 카테고리 이름을 color shape usefor ... 으로 하고
    * 카테고리 안 내용(화이트 그레이 어쩌고)를 배열로 받음.[] 이렇게...
    *   --> 카테고리 안 내용을 color="화이트,그레이,어쩌고," 이런식으로 받고 쪼개는걸 , 기준으로??
    * 그럼 color!=null, 향상된for문으로 하나씩?
    * 쿼리문에서 이 배열과 일치한다면? where color in (a,b,c)
    * https://ojava.tistory.com/12
    * + 검색어가 있다면 검색어랑 일치하는 그거 보여주기.
    * 최신순 별점순 리뷰순 낮은가격순은 정렬조건...
    * 카테고리랑 검색어?*/

    /*유지보수를 포기하자!!*/
    public Page<Item> itemList(String keyword,
                               String[] colors, String[] shapes, String[] usefors,
                               String[] textures, String[] patterns, String[] seasons,
                               Pageable pageable);
}
