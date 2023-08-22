package com.example.librarymanagement.CustomExceptions;

public class BookNotAvailableException extends Exception {

    public BookNotAvailableException(String message) {
        super(message);
    }
}