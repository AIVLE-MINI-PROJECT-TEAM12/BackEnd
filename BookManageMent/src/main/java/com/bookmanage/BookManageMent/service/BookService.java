package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Integer book_id);
    Book create(BookDTO.Post bookDto);
    Book update(Integer book_id, BookDTO.Put bookDTO);
    Book update(Integer book_id, BookDTO.Patch bookDTO);
    void delete(Integer book_id);
}