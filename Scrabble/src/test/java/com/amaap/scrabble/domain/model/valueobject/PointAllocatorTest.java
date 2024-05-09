package com.amaap.scrabble.domain.model.valueobject;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PointAllocatorTest {
    PointAllocator allocator1;
    PointAllocator allocator2;
    PointAllocator allocator3;

    void setUpData() {
        Map<Integer, List<String>> scores1 = new HashMap<>();
        scores1.put(1, List.of("A", "E", "I"));
        scores1.put(2, List.of("D", "G"));
        allocator1 = new PointAllocator(scores1);

        Map<Integer, List<String>> scores2 = new HashMap<>();
        scores2.put(1, List.of("A", "E", "I"));
        scores2.put(2, List.of("D", "G"));
        allocator2 = new PointAllocator(scores2);

        Map<Integer, List<String>> scores3 = new HashMap<>();
        scores3.put(1, List.of("A", "E", "I"));
        scores3.put(3, List.of("B", "C"));
        allocator3 = new PointAllocator(scores3);
    }

    @Test
    void shouldBeAbleToReturnSameAndDifferentHashCodeForSameAndDifferentInstances() {
        // arrange
        setUpData();

        // act && assert
        assertEquals(allocator1.hashCode(), allocator2.hashCode());
        assertNotEquals(allocator1.hashCode(), allocator3.hashCode());
    }
}