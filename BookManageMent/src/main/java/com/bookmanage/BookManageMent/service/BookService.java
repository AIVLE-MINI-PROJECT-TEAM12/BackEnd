package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO.Response> findAll(String token);
    Book findBookById(String token, Integer book_id);
    BookDTO.Response findById(String token, Integer book_id);
    BookDTO.Response create(String token, BookDTO.Post bookDto);
    BookDTO.Response update(String token, Integer book_id, BookDTO.Put bookDTO);
    BookDTO.Response update(String token, Integer book_id, BookDTO.Patch bookDTO);
    void delete(String token, Integer book_id);
}
