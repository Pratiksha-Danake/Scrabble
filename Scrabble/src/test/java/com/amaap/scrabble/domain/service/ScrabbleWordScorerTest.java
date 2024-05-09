package com.amaap.scrabble.domain.service;

import com.amaap.scrabble.AppModule;
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

        // act
        int actualScore = scrabbleWordScorer.getScore(word);

        // assert
        assertEquals(expectedScore, actualScore);
    }
}