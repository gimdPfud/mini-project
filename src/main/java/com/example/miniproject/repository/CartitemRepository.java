package com.example.miniproject.repository;

import com.example.miniproject.entity.Cartitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartitemRepository extends JpaRepository<Cartitem, Long> {
}