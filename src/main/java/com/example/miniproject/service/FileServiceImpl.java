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

        /* 1. 파일 이름을 가져온다. (짱구.png) */
        String oriImgName = multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().lastIndexOf("/")+1);
        /* 2. 랜덤한 문자열을 만든다. (파일 저장할 때 중복되지 말라고 앞에다 붙여줄 용도) */
        UUID uuid = UUID.randomUUID();

        /* 3. 저장할 파일 이름을 생성한다. (uuid_짱구.png)*/
        String imgName = uuid.toString() + "_" + oriImgName;

        /* 4. 파일 경로를 생성한다. (C:/mpj/uuid_짱구.png)*/
        String fileUploadPath = imgLocation + imgName;

        /* 5. 물리적인 저장*/
        //예외 날리기
        FileOutputStream fos = new FileOutputStream(fileUploadPath);
        fos.write(multipartFile.getBytes());
        fos.close();

        /* 6. 멀티파트 파일로 imageDTO 만들기.*/
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setOriImgName(oriImgName);
        imageDTO.setImgName(imgName);
        imageDTO.setImgUrl(imgLocation);
        /* 7. 만든 imageDTO 반환하기. */
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
