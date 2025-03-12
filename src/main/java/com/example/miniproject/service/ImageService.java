package com.example.miniproject.service;

import com.example.miniproject.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    public ImageDTO register(MultipartFile multipartFile,
                             String entityType , Long entity_id, String isthumb) throws IOException;

    public List<ImageDTO> read(String entityType, Long entity_id);

    public void delete(Long image_id);
}
