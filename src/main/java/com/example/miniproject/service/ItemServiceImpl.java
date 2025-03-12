package com.example.miniproject.service;

import com.example.miniproject.dto.ImageDTO;
import com.example.miniproject.dto.ItemDTO;
import com.example.miniproject.entity.Item;
import com.example.miniproject.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Log4j2
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ModelMapper modelMapper;
    private final ImageService imageService;
    private final ItemRepository itemRepository;

    @Override
    public Long register(ItemDTO itemDTO, MultipartFile mainImg, MultipartFile[] multipartFiles) throws IOException {
        log.info("상품 등록 서비스 : "+itemDTO);
        Item item = modelMapper.map(itemDTO, Item.class);
        item = itemRepository.save(item);

        /*todo 이미지 저장 등록*/
        //대표이미지 저장
        imageService.register(mainImg, "item", item.getId(), "Y");

        //상세이미지 저장
        if(multipartFiles!=null){
            for (MultipartFile file : multipartFiles) {
                imageService.register(file,"item", item.getId(), null);
            }
        }

        return item.getId();
    }

    @Override
    public ItemDTO itemDetail(Long id) {
        return null;
    }

    @Override
    public Page<ItemDTO> itemlist(Pageable pageable, String keyword,
                                  String[] colors, String[] shapes,
                                  String[] usefors, String[] textures,
                                  String[] patterns, String[] seasons) {
        Page<Item> itemPage = itemRepository.itemList(keyword, colors, shapes,usefors,textures,patterns,seasons,pageable);

        /*dto타입으로 변환..*/
        Page<ItemDTO> itemDTOPage = itemPage.map(item -> modelMapper.map(item, ItemDTO.class)
                .setImageDTOList(item.getImageList().stream().map(image -> modelMapper.map(image, ImageDTO.class)).toList()));

        return itemDTOPage;
    }

    @Override
    public Long itemUpdate(ItemDTO itemDTO) {
        return 0L;
    }
}
