package com.example.miniproject.repository;

import com.example.myproject.entity.Ordersitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersitemRepository extends JpaRepository<Ordersitem, Long> {
}
