package com.aivle.booksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

public class UserDTO {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Post {

        private String userName;
        private Long token;
        private LocalDateTime createdDate;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Get {
        private String userName;
        private Long token;
        private LocalDateTime createdDate;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private String userName;
        private Long token;
        private LocalDateTime createdDate;
    }
}
