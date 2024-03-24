package com.amaap.scrabble.domain.exceptions;

public class InvalidInputWordException extends Exception{
    public InvalidInputWordException(String word) {
        super(word);
    }
}
