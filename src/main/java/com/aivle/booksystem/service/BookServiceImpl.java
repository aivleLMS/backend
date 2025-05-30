package com.aivle.booksystem.service;

import com.aivle.booksystem.domain.Book;
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
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book not found")
        );
    }

    @Override
    public Book updateBook(Book book) {
        Book oldBook = findBookById(book.getId());

        oldBook.setTitle(book.getTitle());
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
