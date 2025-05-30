package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<Book> findAll(String token);
    Book findById(String token, Integer book_id);
    Book create(String token, BookDTO.Post bookDto);
    Book update(String token, Integer book_id, BookDTO.Put bookDTO);
    Book update(String token, Integer book_id, BookDTO.Patch bookDTO);
    void delete(String token, Integer book_id);
}
