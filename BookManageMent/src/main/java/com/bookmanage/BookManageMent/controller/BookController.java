package com.bookmanage.BookManageMent.controller;

import com.bookmanage.BookManageMent.dto.BookDTO;
import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody BookDTO.Post bookDto) {
        // 예시: user_id와 날짜는 컨트롤러에서 기본값 넣거나, DTO에 포함시켜야 함
        Book book = bookService.create(bookDto);
        book.setUser_id(1); // 테스트용 user_id
        book.setCreate_date(LocalDateTime.now());
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody BookDTO.Put bookDto) {
        return bookService.update(id, bookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.delete(id);
    }

    @PatchMapping(("/{id}/cover"))
    public Book update(@PathVariable Integer book_id, BookDTO.Patch bookDTO){
        return bookService.update(book_id, bookDTO);
    }
}

