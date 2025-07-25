package com.micro.book.book_service.Controller;

import com.micro.book.book_service.DTO.BookResponse;
import com.micro.book.book_service.Entity.BookEntity;
import com.micro.book.book_service.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public BookEntity addBook(@RequestBody BookEntity book){
        return service.saveBook(book);
    }

    @GetMapping
    public List<BookEntity> getBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookEntity getBook(@PathVariable Long id){
        return service.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        service.deleteBook(id);
    }

    @GetMapping("/{id}/user")
    public BookResponse getBookWithUser(@PathVariable Long id){
        return service.getBookWithUser(id);
    }
}
