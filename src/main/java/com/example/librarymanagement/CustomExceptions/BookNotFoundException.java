package com.example.librarymanagement.CustomExceptions;

public class BookNotFoundException extends Exception{

    public BookNotFoundException(String message) {
        super(message);
    }
}