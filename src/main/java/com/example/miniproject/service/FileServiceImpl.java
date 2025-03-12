package com.example.miniproject.service;

import com.example.miniproject.dto.ImageDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Log4j2
public class FileServiceImpl implements FileService{
    @Value("C:/mpj/")
    String imgLocation;

    @Override
    public ImageDTO register(MultipartFile multipartFile) throws IOException {
        String oriImgName = multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().lastIndexOf("/")+1);
        UUID uuid = UUID.randomUUID();
        String imgName = uuid.toString() + "_" + oriImgName;
        String fileUploadPath = imgLocation + imgName;

        /*물리적인 저장*/
        //예외 날리기
        FileOutputStream fos = new FileOutputStream(fileUploadPath);
        fos.write(multipartFile.getBytes());
        fos.close();

        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setOriImgName(oriImgName);
        imageDTO.setImgName(imgName);
        imageDTO.setImgUrl(imgLocation);

        return imageDTO;
    }

    @Override
    public void delete(String path) {
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
    }
}
