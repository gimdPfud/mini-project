package com.example.miniproject.repository;

import com.example.miniproject.entity.Item;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ItemSearchImpl extends QuerydslRepositorySupport implements ItemSearch{

    public ItemSearchImpl() {
        // 어떤 entity를 가지고 만들것이냐? 테이블에 해당하는 entity
        super(Item.class);
    }


}
