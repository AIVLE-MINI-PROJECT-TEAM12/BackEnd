package com.bookmanage.BookManageMent.service;

import com.bookmanage.BookManageMent.domain.Book;
import com.bookmanage.BookManageMent.dto.BookDTO;
import com.bookmanage.BookManageMent.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer book_id) {
        return bookRepository.findById(book_id)
                .orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
    }

    @Override
    public Book create(BookDTO.Post bookDto) {
        Book book = Book.builder()
                .book_name(bookDto.getBook_name())
                .create_date(LocalDateTime.now())
                .summary(bookDto.getSummary())
                .build();

        return bookRepository.save(book);
    }

    @Override
    public Book update(Integer book_id, BookDTO.Put bookDto) {
        Book book = findById(book_id);
        book.setBook_name(bookDto.getBook_name());
        book.setSummary(bookDto.getSummary());
        book.setModify_date(LocalDateTime.now());
        return bookRepository.save(book);
    }

    @Override
    public Book update(Integer book_id, BookDTO.Patch bookDTO) {
        Book book = findById(book_id);
        book.setBook_image(bookDTO.getBook_image());
        return bookRepository.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }
}


