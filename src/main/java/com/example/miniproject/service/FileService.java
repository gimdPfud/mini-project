package com.example.miniproject.service;

import com.example.miniproject.dto.ImageDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    public ImageDTO register(MultipartFile multipartFile) throws IOException;

    public void delete(String path);
}
