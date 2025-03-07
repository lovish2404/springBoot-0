package com.example.tempor.service;

import com.example.tempor.dao.PublisherRepo;
import com.example.tempor.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublisherService {

    @Autowired
    PublisherRepo publisherRepo;

    public Publisher addPublisher(Publisher publisher){
       return publisherRepo.save(publisher);
    }

    public List<Publisher> findPublishers(){
        return (List<Publisher>)publisherRepo.findAll();
    }

    public Publisher findPublisher(int id){
        return publisherRepo.findById((Integer) id).orElse(null);
    }

    public Publisher updatePublisher(Publisher publisher,int id){
        publisher.setId(id);
        return publisherRepo.save(publisher);
    }
    public void deletePublisher(int id){
        publisherRepo.deleteById((Integer) id);
    }

}
