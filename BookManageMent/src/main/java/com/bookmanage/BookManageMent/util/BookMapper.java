package com.bookmanage.BookManageMent.util;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;

public class BookMapper {

    public static BookDTO.Response toResponse(Book book) {
        return new BookDTO.Response(
                book.getUser().getUser_id(),
                book.getUser().getUser_name(),
                book.getBook_id(),
                book.getBook_name(),
                book.getCreate_date(),
                book.getModify_date(),
                book.getSummary(),
                book.getBook_image()
        );
    }
}
