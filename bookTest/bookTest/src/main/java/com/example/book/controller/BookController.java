package com.example.book.controller;

import com.example.book.domain.Book;
import com.example.book.domain.User;
import com.example.book.repository.BookRepository;
import com.example.book.repository.UserRepository;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@RequestMapping({"/books", "/api/v1/books"})
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    // 1. 도서 목록 조회
    @GetMapping
    public List<Map<String, Object>> getBooks(@RequestParam Integer user_id) {
        List<Book> books = bookRepository.findByUserId(user_id);
        Optional<User> user = userRepository.findById(user_id);

        List<Map<String, Object>> result = new ArrayList<>();
        for (Book b : books) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", b.getBook_id());
            map.put("book_name", b.getBook_name());
            map.put("summary", b.getSummary());
            map.put("user_id", b.getUser_id());
            map.put("user_name", user.map(User::getUser_name).orElse("Unknown"));
            result.add(map);
        }
        return result;
    }

    // 2. 도서 등록
    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Map<String, Object> body) {
        Integer user_id = (Integer) body.get("user_id");
        String book_name = (String) body.get("book_name");
        String summary = (String) body.get("summary");

        if (book_name == null || book_name.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "error",
                    "message", "제목은 필수 입력값입니다."
            ));
        }

        Book book = new Book();
        book.setUser_id(user_id);
        book.setBook_name(book_name);
        book.setSummary(summary);
        book.setCreate_date(LocalDateTime.now());

        Book saved = bookRepository.save(book);
        User user = userRepository.findById(user_id).orElse(new User(user_id, "Unknown"));

        Map<String, Object> response = new HashMap<>();
        response.put("id", saved.getBook_id());
        response.put("book_name", saved.getBook_name());
        response.put("summary", saved.getSummary());
        response.put("user_id", saved.getUser_id());
        response.put("user_name", user.getUser_name());

        return ResponseEntity.status(201).body(response);
    }

    // 3. 도서 상세 조회
    @GetMapping("/{book_id}")
    public ResponseEntity<?> getBookDetail(@PathVariable Integer book_id) {
        Book book = bookRepository.findById(book_id).orElse(null);
        if (book == null) {
            return ResponseEntity.status(404).body(Map.of(
                    "status", "error",
                    "message", "해당 도서를 찾을 수 없습니다."
            ));
        }

        User user = userRepository.findById(book.getUser_id()).orElse(new User(book.getUser_id(), "Unknown"));

        Map<String, Object> response = new HashMap<>();
        response.put("id", book.getBook_id());
        response.put("book_name", book.getBook_name());
        response.put("summary", book.getSummary());
        response.put("create_date", book.getCreate_date());
        response.put("modify_date", book.getModify_date());
        response.put("user_id", book.getUser_id());
        response.put("user_name", user.getUser_name());
        response.put("book_image", book.getBook_image());

        return ResponseEntity.ok(response);
    }
}

