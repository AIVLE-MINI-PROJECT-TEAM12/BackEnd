package com.bookmanage.BookManageMent.controller;

import com.bookmanage.BookManageMent.dto.BookDTO;
import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/books", "/api/v1/books"})
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDTO.Response> getAllBooks(@RequestHeader("Authorization") String token) {
        System.out.println("GET /books");
        return bookService.findAll(token);
    }

    @GetMapping("/{id}")
    public BookDTO.Response getBookById(@RequestHeader("Authorization") String token, @PathVariable Integer id) {
        System.out.println("GET /books/" + id.toString());
        return bookService.findById(token, id);
    }

    @GetMapping("/my")
    public List<BookDTO.Response> getMyBooks(@RequestHeader("Authorization") String token) {
        System.out.println("GET /books/my");
        return bookService.findAll(token);
    }

    @PostMapping
    public BookDTO.Response createBook(@RequestHeader("Authorization") String token, @RequestBody BookDTO.Post bookDto) {
        System.out.println("POST /books");
        return bookService.create(token, bookDto);
    }

    @PutMapping("/{id}")
    public BookDTO.Response updateBook(@RequestHeader("Authorization") String token, @PathVariable Integer id, @RequestBody BookDTO.Put bookDto) {
        System.out.println("PUT /books/" + id.toString());
        return bookService.update(token, id, bookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@RequestHeader("Authorization") String token, @PathVariable Integer id) {
        System.out.println("DELETE /books/" + id.toString());
        bookService.delete(token, id);
    }

    @PatchMapping("/{id}/cover")
    public BookDTO.Response updateBookCover(@RequestHeader("Authorization") String token,
                                @PathVariable Integer id,
                                @RequestBody BookDTO.Patch bookDto) {
        System.out.println("PATCH /books/" + id.toString() + "/cover");
        return bookService.update(token, id, bookDto);
    }

}
