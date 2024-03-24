package com.amaap.scrabble.domain.test.validators;

import com.amaap.scrabble.domain.exceptions.InvalidInputWordException;
import com.amaap.scrabble.domain.validators.InputWordValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputWordValidatorTest {
    @Test
    void shouldAbleToThrowInvalidInputWordExceptionWhenWordIsEmpty() {
        //Arrange
        String word = "";
        //act and assert
        Assertions.assertThrows(InvalidInputWordException.class, () ->
                InputWordValidator.isValidWord(word));
    }

    @Test
    void shouldAbleToThrowInvalidInputWordExceptionWhenWordIsNull() {
        //Arrange
        String word = null;
        //act and assert
        Assertions.assertThrows(InvalidInputWordException.class, () ->
                InputWordValidator.isValidWord(word));
    }

    @Test
    void shouldAbleToThrowInvalidInputWordExceptionWhenWordContainsAnySpecialSymbolAndDigit() {
        //Arrange
        String word = "Hello@123";
        //act and assert
        Assertions.assertThrows(InvalidInputWordException.class, () ->
                InputWordValidator.isValidWord(word));
    }

    @Test
    void shouldAbleToReturnTrueWhenInputWordIsValid() throws InvalidInputWordException {
        //Arrange
        String word = "ABC";
        boolean expected = true;
        //act
        boolean isValidWord = InputWordValidator.isValidWord(word);
        // assert
        Assertions.assertEquals(expected, isValidWord);
    }
}
