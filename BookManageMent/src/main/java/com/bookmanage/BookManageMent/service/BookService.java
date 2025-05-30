package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Integer id);
    Book create(BookDTO bookDto);
    Book update(Integer id, BookDTO bookDTO);
    Book update(Integer id, String imageURL);
    void delete(Integer id);
}