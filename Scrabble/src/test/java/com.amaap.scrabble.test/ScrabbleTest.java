package com.amaap.scrabble.test;

import com.amaap.scrabble.domain.Scrabble;
import com.amaap.scrabble.domain.PointAllocator;
import com.amaap.scrabble.domain.ScoreCalculator;
import com.amaap.scrabble.exceptions.InvalidInputWordException;
import com.amaap.scrabble.Multiplier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScrabbleTest {
    PointAllocator pointAllocator = new PointAllocator();
    ScoreCalculator scoreCalculator = new ScoreCalculator(pointAllocator);
    Scrabble scrabble = new Scrabble(scoreCalculator);

    @Test
    void shouldAbleToThrowExceptionWhenWordPassedIsNull() {
        //Arrange
        String word = null;
        Multiplier letterMultiplier = Multiplier.ZERO;
        Multiplier wordMultiplier = Multiplier.ZERO;
        char letterToMultiplyScore = 'A';
        //Act && Assert
        assertThrows(InvalidInputWordException.class, () -> {
            scrabble.getScoreForWord(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);
        }, word);
    }

    @Test
    void shouldAbleToThrowExceptionWhenWordPassedIsEmpty() {
        //Arrange
        char letterToMultiplyScore = 'A';
        String word = "";
        Multiplier letterMultiplier = Multiplier.ZERO;
        Multiplier wordMultiplier = Multiplier.ZERO;

        //Act && Assert
        assertThrows(InvalidInputWordException.class, () -> {
            scrabble.getScoreForWord(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);
        }, word);
    }

    @Test
    void shouldAbleToCalculateScoreForAWordWhereMultiplierForLetterAndWordIsZero() throws InvalidInputWordException {
        //Arrange
        String word = "GUARD";
        char letterToMultiplyScore = 'A';
        Integer expectedScore = 7;
        Multiplier letterMultiplier = Multiplier.ZERO;
        Multiplier wordMultiplier = Multiplier.ZERO;
        //Act
        int actualWordScore = scrabble.getScoreForWord(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);
        //Assert
        assertEquals(expectedScore, actualWordScore);
    }

    @Test
    void shouldAbleToCalculateScoreOfAWordWhereMultiplierForLetterAndWordIsDouble() throws InvalidInputWordException {
        //Arrange
        String word = "GUARD";
        Multiplier letterMultiplier = Multiplier.DOUBLE;
        Multiplier wordMultiplier = Multiplier.DOUBLE;
        Integer expectedScore = 16;
        char letterToMultiplyScore = 'A';
        //Act
        int actualScore = scrabble.getScoreForWord(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);
        //Assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldAbleToCalculateScoreOfAWordWhereMultiplierForLetterAndWordIsTriple() throws InvalidInputWordException {
        //Arrange
        String word = "GUARD";
        Multiplier letterMultiplier = Multiplier.TRIPLE;
        Multiplier wordMultiplier = Multiplier.TRIPLE;
        char letterToMultiplyScore = 'A';
        Integer expectedScore = 27;
        //Act
        int actualScore = scrabble.getScoreForWord(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);
        //Assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldAbleToCalculateScoreOfAWordWhereLetterMultiplierIsDoubleAndWordMultiplierIsTriple() throws InvalidInputWordException {
        //Arrange
        String word = "GUARD";
        Multiplier letterMultiplier = Multiplier.DOUBLE;
        Multiplier wordMultiplier = Multiplier.TRIPLE;
        char letterToMultiplyScore = 'A';
        Integer expectedScore = 24;
        //Act
        int actualScore = scrabble.getScoreForWord(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);
        //Assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldAbleToCalculateScoreOfAWordWhereLetterMultiplierIsTripleAndWordMultiplierIsDouble() throws InvalidInputWordException {
        //Arrange
        String word = "GUARD";
        Multiplier letterMultiplier = Multiplier.TRIPLE;
        Multiplier wordMultiplier = Multiplier.DOUBLE;
        char letterToMultiplyScore = 'A';
        Integer expectedScore = 18;
        //Act
        int actualScore = scrabble.getScoreForWord(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);
        //Assert
        assertEquals(expectedScore, actualScore);
    }
}
