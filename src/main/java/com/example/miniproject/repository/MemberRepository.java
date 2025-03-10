package com.example.miniproject.repository;

import com.example.miniproject.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member findByEmail (String email);

    public Member findByTel (String tel);
}
