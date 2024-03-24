package com.amaap.scrabble.domain.model;

import com.amaap.scrabble.Multiplier;

import java.util.List;
import java.util.Map;

public class ScoreCalculator {
    PointAllocator pointAllocator;

    public ScoreCalculator(PointAllocator pointAllocator) {
        this.pointAllocator = pointAllocator;
    }

    public int calculateWordScore(String word, Multiplier letterMultiplier, char letterToMultiplyScore, Multiplier wordMultiplier) {
        int wordScore = 0;
        int letterScore = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letterToMultiplyScore)
                letterScore = calculateCharacterScore(word.charAt(i), letterMultiplier);
            else
                letterScore = calculateCharacterScore(word.charAt(i), Multiplier.ZERO);
            wordScore += letterScore;
        }
        if (wordMultiplier.equals(Multiplier.DOUBLE))
            wordScore *= 2;
        else if (wordMultiplier.equals(Multiplier.TRIPLE))
            wordScore *= 3;
        return wordScore;
    }

    private int calculateCharacterScore(Character ch, Multiplier letterMultiplier) {
        Map<Integer, List<Character>> scores = pointAllocator.getScores();
        int letterScore = scores.entrySet().stream()
                .filter(entry -> entry.getValue().contains(Character.toUpperCase(ch)))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);

        if (letterMultiplier.equals(Multiplier.DOUBLE))
            letterScore *= 2;
        else if (letterMultiplier.equals(Multiplier.TRIPLE))
            letterScore *= 3;
        return letterScore;
    }
}
