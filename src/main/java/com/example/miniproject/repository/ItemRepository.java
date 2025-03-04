package com.example.miniproject.repository;

import com.example.miniproject.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
