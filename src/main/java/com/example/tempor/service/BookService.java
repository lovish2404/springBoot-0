package com.example.tempor.service;

import com.example.tempor.dao.BookRepo;
import com.example.tempor.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {

    @Autowired
    BookRepo bookRepo;



    public Book createBook(Book book){

        return bookRepo.save(book);
    }
    public List<Book> getAllBooks(){
        return (List<Book>)bookRepo.findAll();
    }
    public Book getBook(int id){

        return bookRepo.findById((Integer)id).orElse(null);

    }
    public Book deleteBook(int id){

        Book deletedBook=bookRepo.findById((Integer)id).orElse(null);
        bookRepo.deleteById((Integer)id);
        return deletedBook;
    }
    public Book updateBook(Book b,int id){
        b.setId(id);
        bookRepo.save(b);
        return b;
    }


}
