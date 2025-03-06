package com.example.miniproject.repository;

import com.example.miniproject.entity.Item;
import com.example.miniproject.entity.QItem;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Arrays;
import java.util.List;

public class ItemSearchImpl extends QuerydslRepositorySupport implements ItemSearch{

    public ItemSearchImpl() {
        // 어떤 entity를 가지고 만들것이냐? 테이블에 해당하는 entity
        super(Item.class);
    }


    @Override
    public Page<Item> itemList(String keyword,
                               String[] colors, String[] shapes,
                               String[] usefors, String[] textures,
                               String[] patterns, String[] seasons,
                               Pageable pageable) {

        System.out.println("들어온 파라미터 : ");
        System.out.println(keyword);
        System.out.println(Arrays.toString(colors));
        System.out.println(Arrays.toString(shapes));
        System.out.println(Arrays.toString(usefors));
        System.out.println(Arrays.toString(textures));
        System.out.println(Arrays.toString(patterns));
        System.out.println(Arrays.toString(seasons));
        /*타입이 T라면 날짜검색*/

        QItem item = QItem.item;
        JPQLQuery<Item> query = from(item);

        if ( keyword != null ){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.or(item.name.contains(keyword));
            booleanBuilder.or(item.detail.contains(keyword));
            query.where(booleanBuilder);
        }

        if ( colors != null && colors.length > 0 ){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(item.color.in(colors));
            query.where(booleanBuilder);
        }if ( shapes != null && shapes.length > 0 ){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(item.shape.in(shapes));
            query.where(booleanBuilder);
        }if ( usefors != null && usefors.length > 0 ){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(item.usefor.in(usefors));
            query.where(booleanBuilder);
        }if ( textures != null && textures.length > 0 ){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(item.texture.in(textures));
            query.where(booleanBuilder);
        }if ( patterns != null && patterns.length > 0 ){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(item.pattern.in(patterns));
            query.where(booleanBuilder);
        }if ( seasons != null && seasons.length > 0 ){
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(item.season.in(seasons));
            query.where(booleanBuilder);
        }

        // 페이징 처리
        this.getQuerydsl().applyPagination(pageable, query);

        // 리스트
        List<Item> itemList =
                query.fetch();
        // 총 게시물
        Long count =
                query.fetchCount();

        return new PageImpl<>(itemList, pageable, count);
    }
}
