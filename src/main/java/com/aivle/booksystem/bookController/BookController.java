package com.aivle.booksystem.bookController;

import com.aivle.booksystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.aivle.booksystem.domain.Book;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    // 신규 도서 등록
    @PostMapping
    public Book createBook(@RequestBody Book book) {return bookService.createBook(book);}

    // 도서 목록 확인
    @GetMapping
    public List<Book> getBooks() {return bookService.findBooks();}

    // 도서 상세 정보 조회
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) { return bookService.findBookById(id);}

    // 도서 수정
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    // 도서 삭제
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {bookService.deleteBook(id);}
}
