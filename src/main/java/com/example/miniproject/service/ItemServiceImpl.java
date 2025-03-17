package com.example.miniproject.service;

import com.example.miniproject.dto.ImageDTO;
import com.example.miniproject.dto.ItemDTO;
import com.example.miniproject.dto.PageRequestDTO;
import com.example.miniproject.entity.Item;
import com.example.miniproject.repository.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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
        /*상품 찾아줘!*/
        Item item = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        /*상품의 이미지 찾아줘!*/
        List<ImageDTO> imageDTOList = imageService.read("item", item.getId());
        /*상품DTO안에 이미지저장해!*/
        ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);
        itemDTO.setImageDTOList(imageDTOList);
        return itemDTO;
    }

    @Override
    public Page<ItemDTO> itemlist(PageRequestDTO pageRequestDTO) {
        Page<Item> itemPage = itemRepository.itemList(pageRequestDTO.getKeyword(), pageRequestDTO.getColors(), pageRequestDTO.getShapes(), pageRequestDTO.getUsefors(), pageRequestDTO.getTextures(), pageRequestDTO.getPatterns(), pageRequestDTO.getSeasons(),
                pageRequestDTO.pageable("id"));

        /*dto타입으로 변환..*/
        Page<ItemDTO> itemDTOPage = itemPage.map(item -> modelMapper.map(item, ItemDTO.class)
                .setImageDTOList(item.getImageList().stream().map(image -> modelMapper.map(image, ImageDTO.class)).toList()));

        return itemDTOPage;
    }

    @Override
    public Long itemUpdate(ItemDTO itemDTO) {
        /*일단 아이템을 찾아와서 아이템.set(디티오)*/
        if(itemRepository.findById(itemDTO.getId()).isPresent()){
            Item item = itemRepository.save(modelMapper.map(itemDTO, Item.class).setId(itemDTO.getId()));
            return item.getId();
        }
        return 0L;
    }
}
