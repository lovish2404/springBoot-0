package com.example.tempor.controllers;


import com.example.tempor.dao.BookRepo;
import com.example.tempor.entity.Book;
import com.example.tempor.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    BookRepo bookRepo;
    @GetMapping("/books")
    public ResponseEntity<List<Book>>getBooks(){

        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
    @PostMapping("/book")
    public ResponseEntity<Book> createBook(@RequestBody  Book book){
        return new ResponseEntity<>(bookService.createBook(book),HttpStatus.CREATED);
    }
    @GetMapping("book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable ("id")  int id){
        return new ResponseEntity<>(bookService.getBook(id),HttpStatus.OK);
    }
    @PutMapping("book/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book,@PathVariable("id") int id){
        return new ResponseEntity<>(bookService.updateBook(book,id),HttpStatus.ACCEPTED);
    }


}
