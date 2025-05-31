package com.aivle.booksystem.service.book;

import com.aivle.booksystem.domain.Book;
import com.aivle.booksystem.exception.BookNotFoundException;
import com.aivle.booksystem.exception.RequiredFieldEmptyException;
import com.aivle.booksystem.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        if (book.getTitle().isBlank()) {
            throw new RequiredFieldEmptyException("제목은 필수 입력 항목입니다.");
        }
        if (book.getStory().isBlank()) {
            throw new RequiredFieldEmptyException("책 내용은 필수 입력 항목입니다.");
        }

        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException("도서를 찾을 수 없습니다.")
        );
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book oldBook = findBookById(id);

        if (book.getTitle().isBlank()) {
            throw new RequiredFieldEmptyException("제목은 필수 입력 항목입니다.");
        }
        oldBook.setTitle(book.getTitle());

        if (book.getStory().isBlank()) {
            throw new RequiredFieldEmptyException("책 내용은 필수 입력 항목입니다.");
        }
        oldBook.setStory(book.getStory());

        oldBook.setCategory(book.getCategory());
        oldBook.setBookCoverUrl(book.getBookCoverUrl());

        return bookRepository.save(oldBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
