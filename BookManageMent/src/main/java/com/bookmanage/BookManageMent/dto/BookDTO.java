package com.bookmanage.BookManageMent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Post{
        private Integer user_id;    // 작성자
        private String book_name;   // 제목
        private String summary;     // 요약
        private String book_image;    // 이미지
    }

    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Put{
        private String book_name;
        private String summary;
        private String book_image;
    }


    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response{
        private Integer user_id;
        private Integer book_id;
        private String book_name;
        private LocalDateTime create_date;
        private LocalDateTime modify_date;
        private String summary;
        private String book_image;
    }

    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Patch{
        private String book_image;
    }




}

