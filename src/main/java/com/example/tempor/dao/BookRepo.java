package com.example.tempor.dao;

import com.example.tempor.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepo extends CrudRepository<Book,Integer> {
}
