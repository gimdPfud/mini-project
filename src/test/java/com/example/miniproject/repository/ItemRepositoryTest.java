package com.example.miniproject.repository;

import com.example.miniproject.constant.ItemSellStatus;
import com.example.miniproject.entity.Item;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;
    @Test
    void insertTest(){
        Item item = new Item();
        item.setName("이름");
        item.setPrice(100);
        item.setDetail("상세설명");
        item.setItemSellStatus(ItemSellStatus.SALE);
        item.setUnit(1);
        item.setShipcost(0);

        log.info(item);
        log.info(itemRepository.save(item));
    }

}