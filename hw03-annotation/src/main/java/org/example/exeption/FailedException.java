package org.example.exeption;

public class FailedException extends RuntimeException{
    public FailedException(String message) {
        super(message);
    }
}
