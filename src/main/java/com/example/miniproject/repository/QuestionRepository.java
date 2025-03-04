package com.example.miniproject.repository;

import com.example.miniproject.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    /*답변 안된 문의만 모아서 보기*/
    public Page<Question> findByIsreplied (boolean isreplied, Pageable pageable);

    /*내가 쓴 문의 보기*/
    public Page<Question> findByCreateBy (String createBy, Pageable pageable);
}