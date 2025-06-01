package com.aivle.booksystem.dto;
//
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

public class BookDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Post {

        private Long id;
        private String title;
        private String story;
        private String category;
        private String bookCoverUrl;
        private LocalDateTime createDate;

    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Put {

        private Long id;
        private String title;
        private String story;
        private String category;
        private String bookCoverUrl;
        private LocalDateTime createDate;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String title;
        private String story;
        private String category;
        private String bookCoverUrl;
        private LocalDateTime createDate;
    }

}

