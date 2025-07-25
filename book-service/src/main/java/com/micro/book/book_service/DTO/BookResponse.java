package com.micro.book.book_service.DTO;

import com.micro.book.book_service.Entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookResponse {
    private BookEntity book;
    private User user;
}
