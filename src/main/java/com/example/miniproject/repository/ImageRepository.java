package com.example.miniproject.repository;

import com.example.miniproject.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    /*상품에 달린 이미지 모두 찾기*/
    public List<Image> findByItemId(Long id);

    /*문의에 달린 이미지 모두 찾기*/
    public List<Image> findByQuestionId(Long id);

    /*문의에 달린 이미지 모두 찾기*/
    public List<Image> findByReviewId(Long id);


    /*상품에 달린 대표이미지 찾기*/
    public Image findByItemIdAndIsthumb(Long id, String y);

    /*문의에 달린 대표이미지 찾기*/
    public Image findByQuestionIdAndIsthumb(Long id, String y);

    /*리뷰에 달린 대표이미지 찾기*/
    public Image findByReviewIdAndIsthumb(Long id, String y);

}
