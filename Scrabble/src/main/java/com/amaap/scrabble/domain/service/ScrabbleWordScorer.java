package com.amaap.scrabble.domain.service;

import com.amaap.scrabble.domain.model.valueobject.Multiplier;
import com.amaap.scrabble.domain.model.valueobject.PointAllocator;
import com.google.inject.Inject;

import java.util.List;
import java.util.Map;

public class ScrabbleWordScorer {
    private final PointAllocator pointAllocator;

    @Inject
    public ScrabbleWordScorer(PointAllocator pointAllocator) {
        this.pointAllocator = pointAllocator;
    }

    private static int getMultipliedScore(Multiplier multiplier, int score) {
        if (multiplier.equals(Multiplier.DOUBLE))
            score *= 2;
        else if (multiplier.equals(Multiplier.TRIPLE))
            score *= 3;
        return score;
    }

    public int getScore(String word, Multiplier letterMultiplier, char letterToMultiplyScore, Multiplier wordMultiplier) {
        int wordScore = 0;
        int letterScore = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letterToMultiplyScore)
                letterScore = getLetterScore(word.charAt(i), letterMultiplier);
            else
                letterScore = getLetterScore(word.charAt(i), Multiplier.ZERO);
            wordScore += letterScore;
        }
        return getMultipliedScore(wordMultiplier, wordScore);
    }

    private int getLetterScore(char ch, Multiplier multiplier) {
        Map<Integer, List<String>> scores = pointAllocator.getScores();
        int letterScore = scores.entrySet().stream()
                .filter(entry -> entry.getValue().stream().anyMatch(letter -> letter.equalsIgnoreCase(String.valueOf(ch))))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);

        return getMultipliedScore(multiplier, letterScore);
    }
}
