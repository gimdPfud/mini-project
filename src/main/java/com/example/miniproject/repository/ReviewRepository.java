package com.example.miniproject.repository;

import com.example.miniproject.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    public Page<Review> findByOrdersitemItemId(Long id, Pageable pageable);
    /*todo 이거 되는지 안되는지 몰르겟다.
    *  리뷰 안에 주문상품안에 상품pk로 리뷰를 페이징처리해서 가져온다.*/
}
