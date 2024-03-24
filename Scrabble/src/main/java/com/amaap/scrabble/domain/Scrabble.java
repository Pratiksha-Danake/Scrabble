package com.amaap.scrabble.domain;

import com.amaap.scrabble.Multiplier;
import com.amaap.scrabble.domain.model.ScoreCalculator;
import com.amaap.scrabble.domain.exceptions.InvalidInputWordException;
import com.amaap.scrabble.domain.validators.InputWordValidator;

public class Scrabble {
    ScoreCalculator scoreCalculator;

    public Scrabble(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public int getScoreForWord(String word, Multiplier letterMultiplier, char letterToMultiplyScore, Multiplier wordMultiplier) throws InvalidInputWordException {
        int wordScore = 0;
        if (InputWordValidator.isValidWord(word))
            wordScore = scoreCalculator.calculateWordScore(word, letterMultiplier, letterToMultiplyScore, wordMultiplier);
        else
            return 0;
        return wordScore;
    }
}