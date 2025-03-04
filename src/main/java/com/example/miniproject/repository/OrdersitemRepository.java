package com.example.miniproject.repository;

import com.example.miniproject.entity.Ordersitem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersitemRepository extends JpaRepository<Ordersitem, Long> {

    public List<Ordersitem> findByOrdersOrderscode(String orderscode);
}
