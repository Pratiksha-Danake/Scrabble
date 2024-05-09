package com.amaap.scrabble.domain.service;

import com.amaap.scrabble.AppModule;
import com.amaap.scrabble.domain.model.valueobject.Multiplier;
import com.amaap.scrabble.io.ConfigFileLoader;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScrabbleWordScorerTest {
    ScrabbleWordScorer scrabbleWordScorer;
    ConfigFileLoader configFileLoader;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        Injector injector = Guice.createInjector(new AppModule());
        scrabbleWordScorer = injector.getInstance(ScrabbleWordScorer.class);
        configFileLoader = injector.getInstance(ConfigFileLoader.class);
        String configFilePath = "E:\\Scrabble\\Scrabble\\src\\main\\java\\resources\\config.yaml";
        configFileLoader.loadConfigFile(configFilePath);
    }

    @Test
    void shouldBeAbleToCalculateScoreOfTheWord() {
        // arrange
        String word = "Hello";
        int expectedScore = 8;
        Multiplier letterMultiplier = Multiplier.ZERO;
        char letterToMultiplyScore = 'e';
        Multiplier wordMultiplier = Multiplier.ZERO;

        // act
        int actualScore = scrabbleWordScorer.getScore(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);

        // assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldAbleToCalculateScoreForAWordWhereMultiplierForLetterAndWordIsZero() {
        // arrange
        String word = "GUARD";
        char letterToMultiplyScore = 'A';
        Integer expectedScore = 7;
        Multiplier letterMultiplier = Multiplier.ZERO;
        Multiplier wordMultiplier = Multiplier.ZERO;

        // act
        int actualWordScore = scrabbleWordScorer.getScore(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);

        // assert
        assertEquals(expectedScore, actualWordScore);
    }

    @Test
    void shouldAbleToCalculateScoreOfAWordWhereMultiplierForLetterAndWordIsDouble() {

        // arrange
        String word = "GUARD";
        Multiplier letterMultiplier = Multiplier.DOUBLE;
        Multiplier wordMultiplier = Multiplier.DOUBLE;
        Integer expectedScore = 16;
        char letterToMultiplyScore = 'A';

        // act
        int actualScore = scrabbleWordScorer.getScore(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);
        System.out.println(actualScore);
        // assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldAbleToCalculateScoreOfAWordWhereMultiplierForLetterAndWordIsTriple() {

        // arrange
        String word = "GUARD";
        Multiplier letterMultiplier = Multiplier.TRIPLE;
        Multiplier wordMultiplier = Multiplier.TRIPLE;
        char letterToMultiplyScore = 'A';
        Integer expectedScore = 27;

        // act
        int actualScore = scrabbleWordScorer.getScore(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);

        // assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldAbleToCalculateScoreOfAWordWhereLetterMultiplierIsDoubleAndWordMultiplierIsTriple() {

        // arrange
        String word = "GUARD";
        Multiplier letterMultiplier = Multiplier.DOUBLE;
        Multiplier wordMultiplier = Multiplier.TRIPLE;
        char letterToMultiplyScore = 'A';
        Integer expectedScore = 24;

        // act
        int actualScore = scrabbleWordScorer.getScore(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);

        // assert
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void shouldAbleToCalculateScoreOfAWordWhereLetterMultiplierIsTripleAndWordMultiplierIsDouble() {

        // arrange
        String word = "GUARD";
        Multiplier letterMultiplier = Multiplier.TRIPLE;
        Multiplier wordMultiplier = Multiplier.DOUBLE;
        char letterToMultiplyScore = 'A';
        Integer expectedScore = 18;

        // act
        int actualScore = scrabbleWordScorer.getScore(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);

        // assert
        assertEquals(expectedScore, actualScore);
    }
}