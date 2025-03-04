package com.example.miniproject.repository;

import com.example.miniproject.entity.Cart;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Test
    void insertTest(){
        Cart cart = cartRepository.findByMemberEmail("tofu@a.a");

        if(cart==null){
            log.info("장바구니 만들 수 있음");
        }else{
            log.info("장바구니 못 만듬");
        }
    }

}