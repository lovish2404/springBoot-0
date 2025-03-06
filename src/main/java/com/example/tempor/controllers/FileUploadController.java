package com.example.tempor.controllers;

import com.example.tempor.helper.UploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class FileUploadController {
    @Autowired
    UploadHelper uploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile file){
        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Empty file");
            }
            if(!"image/png".equals(file.getContentType())){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("only png");
            };
            boolean isOk=uploadHelper.isUploaded(file);
            if(isOk){
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image").path(file.getOriginalFilename()).toUriString() );
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Error ");
    }
}
