package com.example.tempor.controllers;


import com.example.tempor.entity.Book;
import com.example.tempor.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @GetMapping("/books")
    public ResponseEntity getBooks(){

        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
    @PostMapping("/book")
    public ResponseEntity createBook(@RequestBody  Book book){
        return new ResponseEntity(bookService.createBook(book),HttpStatus.CREATED);
    }
    @GetMapping("book/{id}")
    public ResponseEntity getBook(@PathVariable ("id")  int id){
        return new ResponseEntity<>(bookService.getBook(id),HttpStatus.OK);
    }
    @PutMapping("book/{id}")
    public ResponseEntity updateBook(@RequestBody Book book,@PathVariable("id") int id){
        return new ResponseEntity<>(bookService.updateBook(book,id),HttpStatus.ACCEPTED);
    }
}
