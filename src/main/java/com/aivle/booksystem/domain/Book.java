package com.aivle.booksystem.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Lob
    @Column(nullable = false)
    private String story;

    @Enumerated(EnumType.STRING)
    private Book.Category category;

    private String bookCoverUrl;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastUpdateDate;

    public enum Category {
        NOVEL, // 소설
        POETRY_ESSAY, // 시/에세이
        HUMANITIES, // 인문
        FAMILY_PARENTING, // 가정/육아
        HOBBY, // 취미
        SELF_IMPROVEMENT, // 자기계발
        ECONOMY_BUSINESS, // 경제/경영
        SOCIETY, // 정치/사회
        HISTORY_CULTURE, //역사/문화
        RELIGION, // 종교
        ART_POP_CULTURE, // 예술/대중문화
        TECHNOLOGY_ENGINEERING, // 기술/공학
        SCIENCE, // 과학
        TRAVEL // 여행
    }
}
