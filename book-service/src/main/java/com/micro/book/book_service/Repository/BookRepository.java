package com.micro.book.book_service.Repository;

import com.micro.book.book_service.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
