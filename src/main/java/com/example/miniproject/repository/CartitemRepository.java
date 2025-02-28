package com.example.miniproject.repository;

import com.example.myproject.constant.CartStatus;
import com.example.myproject.entity.Cartitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartitemRepository extends JpaRepository<Cartitem, Long> {
    public Cartitem findByCartStatus (CartStatus cartStatus);

}