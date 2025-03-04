package com.example.miniproject.repository;

import com.example.miniproject.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    public Cart findByMemberEmail(String email);
}