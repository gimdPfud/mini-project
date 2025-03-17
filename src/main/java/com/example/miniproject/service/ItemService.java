package com.example.miniproject.service;

import com.example.miniproject.dto.ItemDTO;
import com.example.miniproject.dto.PageRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ItemService {
    /*상품 등록
    * DTO 넣고 pk 받음*/
    public Long register(ItemDTO itemDTO, MultipartFile mainImg, MultipartFile[] multipartFiles) throws IOException;

    /*상품 읽기
    * pk 넣고 DTO 받음*/
    public ItemDTO itemDetail(Long id);

    /*상품 목록*/
    public Page<ItemDTO> itemlist(PageRequestDTO pageRequestDTO);

    /*상품 수정
    * DTO 넣고 pk 받음*/
    public Long itemUpdate(ItemDTO itemDTO);
}
