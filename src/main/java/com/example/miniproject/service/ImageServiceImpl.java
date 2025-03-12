package com.example.miniproject.service;

import com.example.miniproject.dto.ImageDTO;
import com.example.miniproject.entity.Image;
import com.example.miniproject.entity.Item;
import com.example.miniproject.entity.Question;
import com.example.miniproject.entity.Review;
import com.example.miniproject.repository.ImageRepository;
import com.example.miniproject.repository.ItemRepository;
import com.example.miniproject.repository.QuestionRepository;
import com.example.miniproject.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ImageServiceImpl implements ImageService{
    private final ImageRepository imageRepository;
    private final FileService fileService;
    private final ItemRepository itemRepository;
    private final ReviewRepository reviewRepository;
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    @Override
    public ImageDTO register(MultipartFile multipartFile, String entityType, Long entity_id, String isthumb) throws IOException {
        //사진 물리저장
        ImageDTO imageDTO = fileService.register(multipartFile);

        //변환
        Image image = modelMapper.map(imageDTO, Image.class);

        /*참조대상 지정.*/
        Item item = null;
        Review review = null;
        Question question = null;

        if (entityType.equals("item")){
            item = itemRepository.findById(entity_id).orElseThrow(EntityNotFoundException::new);
            image.setItem(item);
        }
        else if (entityType.equals("review")){
            review = reviewRepository.findById(entity_id).orElseThrow(EntityNotFoundException::new);
            image.setReview(review);
        }
        else if (entityType.equals("question")){
            question = questionRepository.findById(entity_id).orElseThrow(EntityNotFoundException::new);
            image.setQuestion(question);
        }

        //DB저장
        //하기 전 대표이미지가 있다면??
        //
        Image oldthumb = null;
        if(isthumb != null){
            oldthumb = imageRepository.findByItemIdAndIsthumb(entity_id,isthumb);
        }

        if(oldthumb!=null){
            String path = oldthumb.getImgUrl()+oldthumb.getImgName();
            fileService.delete(path);//기존이미지 삭제

            oldthumb.setImgUrl(imageDTO.getImgUrl());
            oldthumb.setImgName(imageDTO.getImgName());
            oldthumb.setOriImgName(imageDTO.getOriImgName());
            /*기존거를 불러오고 업데이트.*/
        }else{
            image.setIsthumb(isthumb);
            image = imageRepository.save(image);
            imageDTO = modelMapper.map(image,ImageDTO.class);
        }
        return imageDTO;
    }

    @Override
    public List<ImageDTO> read(String entityType, Long entity_id) {
        List<Image> imageList = null;
        if(entityType.equals("item")){
            imageList = imageRepository.findByItemId(entity_id);
        }else if(entityType.equals("item")){
            imageList = imageRepository.findByItemId(entity_id);
        }else if(entityType.equals("item")){
            imageList = imageRepository.findByItemId(entity_id);
        }
        List<ImageDTO> imageDTOList = imageList.stream().map(
                image -> modelMapper.map(image, ImageDTO.class))
                .toList();
        return imageDTOList;
    }

    @Override
    public void delete(Long image_id) {
        /*1. DB에서 삭제*/
        Image image = imageRepository.findById(image_id).orElseThrow(EntityNotFoundException::new);
        if(image!=null){
            String path = image.getImgUrl()+image.getImgName();
            /*2. 파일에서 삭제*/
            fileService.delete(path);
            imageRepository.delete(image);
        }
    }
}
