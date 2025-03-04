package com.example.miniproject.repository;

import com.example.miniproject.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

    /*주문번호만 가져오는데??
    * 애초에 불가능한거엿다..
    * 2번째로 생각한거 : 이메일로 주문번호 읽고 주문번호로 주문상품찾고
    * 3번째 : 그냥 쪼인을 한다.*/
    public Page<Orders> findByMemberEmail (String email, Pageable pageable);

}
