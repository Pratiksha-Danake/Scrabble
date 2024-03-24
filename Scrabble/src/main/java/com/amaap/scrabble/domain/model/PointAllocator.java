package com.amaap.scrabble.domain.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointAllocator {
    final private Map<Integer, List<Character>> scores = new HashMap<>();

    public PointAllocator() {
        scores.put(1, List.of('E', 'A', 'I', 'O', 'N', 'R', 'T', 'L', 'S', 'U'));
        scores.put(2, List.of('D', 'G'));
        scores.put(3, List.of('B', 'C', 'M', 'P'));
        scores.put(4, List.of('F', 'H', 'V', 'W', 'Y'));
        scores.put(5, List.of('K'));
        scores.put(8, List.of('J', 'X'));
        scores.put(10, List.of('Q', 'Z'));
    }

    public Map<Integer, List<Character>> getScores() {
        return scores;
    }
}
