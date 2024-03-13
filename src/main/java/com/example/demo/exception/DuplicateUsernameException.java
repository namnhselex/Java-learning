package com.example.demo.exception;

public class DuplicateUsernameException extends Exception{

    public DuplicateUsernameException(String message) {
        super(message);
    }
}
