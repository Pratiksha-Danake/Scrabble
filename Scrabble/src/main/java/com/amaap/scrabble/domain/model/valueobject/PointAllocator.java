package com.amaap.scrabble.domain.model.valueobject;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PointAllocator {
    private final Map<Integer, List<String>> scores;

    public PointAllocator(Map<Integer, List<String>> scores) {
        this.scores = scores;
    }

    public Map<Integer, List<String>> getScores() {
        return scores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointAllocator that = (PointAllocator) o;
        return Objects.equals(scores, that.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scores);
    }
}
