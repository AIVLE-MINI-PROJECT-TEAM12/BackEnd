package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.domain.User;
import com.bookmanage.BookManageMent.dto.BookDTO;
import com.bookmanage.BookManageMent.util.BookMapper;
import com.bookmanage.BookManageMent.repository.BookRepository;
import com.bookmanage.BookManageMent.repository.UserRepository;
import com.bookmanage.BookManageMent.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    private User getUserFromToken(String token) {
        String userId = jwtUtil.validateAndGetUserId(token.replace("Bearer ", ""));
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
    }

    @Override
    public List<BookDTO.Response> findAll(String token) {
        User user = getUserFromToken(token);
        return bookRepository.findAll().stream()
                .filter(book -> book.getUser().getUser_id().equals(user.getUser_id()))
                .map(BookMapper::toResponse)
                .toList();
    }

    @Override
    public BookDTO.Response findById(String token, Integer book_id) {
        User user = getUserFromToken(token);
        Book book = bookRepository.findById(book_id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
        if (!book.getUser().getUser_id().equals(user.getUser_id())) {
            throw new RuntimeException("접근 권한이 없습니다.");
        }
        return BookMapper.toResponse(book);
    }


    @Override
    public BookDTO.Response createBook(String token, BookDTO.Post bookDto) {
        User user = getUserFromToken(token);
        Book book = Book.builder()
                .user(user)
                .book_name(bookDto.getBook_name())
                .summary(bookDto.getSummary())
                .book_image(bookDto.getBook_image())
                .create_date(LocalDateTime.now())
                .build();
        return BookMapper.toResponse(bookRepository.save(book));

    }

    @Override
    public BookDTO.Response update(String token, Integer book_id, BookDTO.Put bookDto) {
        User user = getUserFromToken(token);
        Book book = bookRepository.findById(book_id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));


        if (!book.getUser().getUser_id().equals(user.getUser_id())) {
            throw new RuntimeException("접근 권한이 없습니다.");
        }

        book.setBook_name(bookDto.getBook_name());
        book.setSummary(bookDto.getSummary());
        book.setBook_image(bookDto.getBook_image());
        book.setModify_date(LocalDateTime.now());
        return BookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public BookDTO.Response update(String token, Integer book_id, BookDTO.Patch bookDto) {
        User user = getUserFromToken(token);
        Book book = bookRepository.findById(book_id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));


        if (!book.getUser().getUser_id().equals(user.getUser_id())) {
            throw new RuntimeException("접근 권한이 없습니다.");
        }

        book.setBook_image(bookDto.getBook_image());
        book.setModify_date(LocalDateTime.now());
        return BookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public void delete(String token, Integer book_id) {
        User user = getUserFromToken(token);
        Book book = bookRepository.findById(book_id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));


        if (!book.getUser().getUser_id().equals(user.getUser_id())) {
            throw new RuntimeException("접근 권한이 없습니다.");
        }

        bookRepository.delete(book);
    }
}
