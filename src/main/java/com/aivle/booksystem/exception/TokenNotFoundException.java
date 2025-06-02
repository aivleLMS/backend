package com.aivle.booksystem.exception;

public class TokenNotFoundException extends IllegalArgumentException {

    public TokenNotFoundException(String message) {
        super(message);
    }
}
