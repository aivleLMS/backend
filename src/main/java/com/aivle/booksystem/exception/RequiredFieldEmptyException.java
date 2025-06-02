package com.aivle.booksystem.exception;

public class RequiredFieldEmptyException extends IllegalArgumentException {

    public RequiredFieldEmptyException(String message) {
        super(message);
    }
}
