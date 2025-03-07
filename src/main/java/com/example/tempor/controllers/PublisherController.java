package com.example.tempor.controllers;

import com.example.tempor.entity.Publisher;
import com.example.tempor.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @GetMapping("/publishers")
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        return new ResponseEntity<>(publisherService.findPublishers(), HttpStatus.OK);
    }

    @GetMapping("/publisher/{id}")
    public ResponseEntity<Publisher> getPublisher(@PathVariable("id") int p_id){
        return new ResponseEntity<>(publisherService.findPublisher(p_id),HttpStatus.OK);
    }

    @PostMapping("/publisher")
    public ResponseEntity<Publisher> setPublisher(@RequestBody Publisher publisher){
        return new ResponseEntity<>(publisherService.addPublisher(publisher),HttpStatus.CREATED);
    }

    @DeleteMapping("/publisher/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable("id") int p_id){
        publisherService.deletePublisher(p_id);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

    @PutMapping("/publisher/{id}")
    public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher, @PathVariable ("id") int p_id){
        return new ResponseEntity<>(publisherService.updatePublisher(publisher,p_id),HttpStatus.OK);
    }

}
