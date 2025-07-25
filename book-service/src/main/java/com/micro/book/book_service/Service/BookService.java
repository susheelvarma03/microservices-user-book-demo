package com.micro.book.book_service.Service;

import com.micro.book.book_service.DTO.BookResponse;
import com.micro.book.book_service.DTO.User;
import com.micro.book.book_service.Entity.BookEntity;
import com.micro.book.book_service.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public BookEntity saveBook(BookEntity book){
        return repository.save(book);
    }

    public List<BookEntity> getAllBooks(){
        return repository.findAll();
    }

    public BookEntity getBookById(Long id){
        return repository.findById(id)
                .orElseThrow(() ->new RuntimeException("Book not found with ID: " +id));
    }

    public void deleteBook(Long id){
        repository.deleteById(id);
    }


    public BookResponse getBookWithUser(Long bookId) {
        BookEntity book = repository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        // Check if userId is present
        if (book.getUserId() == null) {
            throw new RuntimeException("User ID not associated with this book");
        }

        // Now safe to make REST call
        User user = restTemplate.getForObject(
                "http://localhost:8082/users/" + book.getUserId(),
                User.class
        );

        return new BookResponse(book, user);
    }
}
