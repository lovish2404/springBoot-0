package com.example.tempor.dao;

import com.example.tempor.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuthorRepo extends MongoRepository<Author,Integer> {

}
