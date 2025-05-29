package com.example.book.repository;

import com.example.book.domain.Book;
import com.example.book.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByUserId(Integer userId);
}
