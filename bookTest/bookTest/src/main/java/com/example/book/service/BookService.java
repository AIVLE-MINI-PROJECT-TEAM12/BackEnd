package com.example.book.service;

import com.example.book.domain.Book;

import java.util.*;

public interface BookService {

    Book insertBook(Book book);
    List<Book> findBooks();
    Book findBook(Integer id);
    Book updateBook(Integer id, Book book);
    Book updateBook(Integer id, String url);
    void deleteBook(Integer id);

}
