package com.example.miniproject.repository;

import com.example.miniproject.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberSearch {
    public Page<Member> memberList(String keyword, Pageable pageable);
}
