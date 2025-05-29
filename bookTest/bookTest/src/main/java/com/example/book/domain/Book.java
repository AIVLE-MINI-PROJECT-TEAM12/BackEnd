package com.example.book.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "book")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;

    @Column(nullable = false)
    private Integer user_id;

    @Column(nullable = false, length = 50)
    private String book_name;

    @Column(nullable = false)
    private LocalDateTime create_date;

    private LocalDateTime modify_date;

    @Column(nullable = false, length = 500)
    private String summary;

    private String book_image;
}
