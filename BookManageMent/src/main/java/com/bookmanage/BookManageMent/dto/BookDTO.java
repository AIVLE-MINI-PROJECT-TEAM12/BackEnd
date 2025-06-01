package com.bookmanage.BookManageMent.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BookDTO {

    @Setter @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Post {
        private String user_id;
        private String book_name;
        private String summary;
        private String book_image;
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
        private String user_id;
        private String user_name;
        private Integer book_id;
        private String book_name;
        private String create_date;
        private String modify_date;
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

