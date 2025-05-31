package com.aivle.booksystem.service.book;

import com.aivle.booksystem.domain.Book;
import java.util.List;

public interface BookService {
    // 신규 도서 등록
    Book createBook(Book book);

    // 도서 목록 확인
    List<Book> findBooks();

    // 도서 상세 정보 조회
    Book findBookById(Long id);

    // 도서 수정
    Book updateBook(Long id, Book book);

    // 도서 삭제
    void deleteBook(Long id);
}
