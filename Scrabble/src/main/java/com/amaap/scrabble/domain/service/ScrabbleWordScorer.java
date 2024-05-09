package com.amaap.scrabble.domain.service;

import com.amaap.scrabble.domain.model.valueobject.PointAllocator;
import com.google.inject.Inject;

import java.util.List;
import java.util.Map;

public class ScrabbleWordScorer {
    private PointAllocator pointAllocator;

    @Inject
    public ScrabbleWordScorer(PointAllocator pointAllocator) {
        this.pointAllocator = pointAllocator;
    }

    public int getScore(String word) {
        int wordScore = 0;
        int letterScore;
        for (int i = 0; i < word.length(); i++) {
            letterScore = calculateLetterScore(word.charAt(i));
            wordScore += letterScore;
        }
        return wordScore;
    }

    private int calculateLetterScore(char ch) {
        Map<Integer, List<String>> scores = pointAllocator.getScores();
        int letterScore = scores.entrySet().stream()
                .filter(entry -> entry.getValue().stream().anyMatch(letter -> letter.equalsIgnoreCase(String.valueOf(ch))))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);
        return letterScore;
    }
}
