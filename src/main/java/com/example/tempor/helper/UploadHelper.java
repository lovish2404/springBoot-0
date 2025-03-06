package com.example.tempor.helper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadHelper {
 private final String upload_DIR=new ClassPathResource("static/image").getFile().getAbsolutePath();

    public UploadHelper() throws IOException {
    }

    public boolean isUploaded(MultipartFile image){
     boolean isSuccess=false;
     try {
         Files.copy(image.getInputStream(), Paths.get(upload_DIR+ File.separator+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
         isSuccess=true;
     }catch(Exception e){
         e.printStackTrace();
     }
     return isSuccess;
 }
}
