package com.example.tempor.service;

import com.example.tempor.dao.AuthorRepo;
import com.example.tempor.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorService {

    @Autowired
    AuthorRepo authorRepo;

    public Author addAuthor(Author author){
        return authorRepo.save(author);
    }

    public List<Author> getAuthors(){
        return authorRepo.findAll();
    }

    public Author getSingleAuthor(int id){
        return authorRepo.findById(id).orElse(null);
    }
    public String deleteAuthor(int id){
        authorRepo.deleteById(id);
        return "deleted author";

    }
    public Author updateAuthor(Author author,int id){
        author.setId(id);
        return authorRepo.save(author);
    }
}
