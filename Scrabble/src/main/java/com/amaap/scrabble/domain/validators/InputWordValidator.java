package com.amaap.scrabble.domain.validators;

import com.amaap.scrabble.domain.exceptions.InvalidInputWordException;

import java.util.regex.Pattern;

public class InputWordValidator {
    public static boolean isValidWord(String word) throws InvalidInputWordException {
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

        if (word == null || word.isEmpty() || !pattern.matcher(word).matches())
            throw new InvalidInputWordException(word);
        return true;
    }
}
