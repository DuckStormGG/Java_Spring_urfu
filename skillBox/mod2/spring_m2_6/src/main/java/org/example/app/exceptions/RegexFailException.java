package org.example.app.exceptions;

public class RegexFailException extends Exception{
    private final String message;

    public RegexFailException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
