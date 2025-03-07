package com.example.tempor.controllers;

import com.example.tempor.entity.Author;
import com.example.tempor.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors(){
        return new ResponseEntity<>(authorService.getAuthors(), HttpStatus.OK);
    }

    @GetMapping("author/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable("id") int authId){
        return new ResponseEntity<>(authorService.getSingleAuthor(authId),HttpStatus.OK);
    }
    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.addAuthor(author),HttpStatus.CREATED);
    }

    @PutMapping("author/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author,@PathVariable("id") int authId){
        return new ResponseEntity<>(authorService.updateAuthor(author,authId),HttpStatus.OK);
    }

    @DeleteMapping("author/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id")int authId){
      return new ResponseEntity<>(authorService.deleteAuthor(authId),HttpStatus.OK);
    }


}
