package com.example.book.service;

import com.example.book.domain.Book;
import com.example.book.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //방법3
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository; // 얜 방법 2,3에 사용
//    public BookServiceImpl(BookRepository bookRepository){
//        this.bookRepository = bookRepository;
//    }
//    방법 2

//    @Autowired
//    private BookRepository bookRepository;
//    방법 1

    @Override
    public Book insertBook(Book book) {
//        book.setStatus(Book.Status.AVAILABLE);
        //status로 뭘 넣든 available이 들어간다.
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBook(Integer id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("책을 찾을 수 없습니다.")
        );
    }

    @Override
    public Book updateBook(Integer id, Book book) {
        //책을 가져온다.
        Book b = findBook(id);

        //책의 내용을 변경한다.
        b.setBook_id(book.getBook_id());
        b.setBook_name(book.getBook_name());
        b.setSummary(book.getSummary());

        //변경된 책을 저장한다.
        return bookRepository.save(b);
    }

    @Override
    public Book updateBook(Integer id, String url) {
        //책의 대출상태만 바꾸고 싶음
        Book b = findBook(id);
        //상태 바꿔준다.
        b.setBook_image(url);
        //변경된 책 저장
        return bookRepository.save(b);
    }

    @Override
    public void deleteBook(Integer id) {
        //id로 책 찾아서 그거 삭제
        bookRepository.deleteById(id);
    }
}
