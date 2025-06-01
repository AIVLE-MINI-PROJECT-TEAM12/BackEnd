package com.bookmanage.BookManageMent.util;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;

import java.time.format.DateTimeFormatter;

public class BookMapper {
    public static BookDTO.Response toResponse(Book book) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return new BookDTO.Response(
            book.getUser().getUser_id(), // User 엔티티에 getUser_id() 메서드가 있다고 가정
            book.getUser().getUser_name(),
            book.getBook_id(),
            book.getBook_name(),
            book.getCreate_date().format(formatter),
            book.getModify_date() != null ? book.getModify_date().format(formatter) : null,
            book.getSummary(),
            book.getBook_image()
        );
    }
}