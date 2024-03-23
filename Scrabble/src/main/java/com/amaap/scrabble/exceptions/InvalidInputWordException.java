package com.amaap.scrabble.exceptions;

public class InvalidInputWordException extends Exception{
    public InvalidInputWordException(String word) {
        super(word);
    }
}
