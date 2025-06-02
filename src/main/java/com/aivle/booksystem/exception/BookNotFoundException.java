package com.aivle.booksystem.exception;

public class BookNotFoundException extends IllegalArgumentException {

    public BookNotFoundException(String message) {
        super(message);
    }
}
