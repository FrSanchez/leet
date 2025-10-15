package com.splabs.codeSignal.algorithms;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerScoreServiceTest {

    PlayerScores service = new PlayerScores();

    @Test
    public void testBasicMatch() {
        List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> scores = Arrays.asList(100, 200, 150, 50, 300);
        List<Integer> queries = Arrays.asList(2, 5, 1);
        List<Integer> expected = Arrays.asList(200, 300, 100);
        assertEquals(expected, service.solution(ids, scores, queries));
    }

    @Test
    public void testMissingQueryIds() {
        List<Integer> ids = Arrays.asList(10, 20, 30);
        List<Integer> scores = Arrays.asList(1000, 2000, 3000);
        List<Integer> queries = Arrays.asList(20, 40, 10, 99);
        List<Integer> expected = Arrays.asList(2000, 1000);
        assertEquals(expected, service.solution(ids, scores, queries));
    }

    @Test
    public void testEmptyQueries() {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        List<Integer> scores = Arrays.asList(10, 20, 30);
        List<Integer> queries = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, service.solution(ids, scores, queries));
    }

    @Test
    public void testEmptyPlayerLists() {
        List<Integer> ids = Collections.emptyList();
        List<Integer> scores = Collections.emptyList();
        List<Integer> queries = Arrays.asList(1, 2, 3);
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, service.solution(ids, scores, queries));
    }

    @Test
    public void testNegativeScores() {
        List<Integer> ids = Arrays.asList(1, 2, 3);
        List<Integer> scores = Arrays.asList(-100, -200, -300);
        List<Integer> queries = Arrays.asList(3, 1);
        List<Integer> expected = Arrays.asList(-300, -100);
        assertEquals(expected, service.solution(ids, scores, queries));
    }

    @Test
    public void testLargeInputPerformance() {
        int size = 100_000;
        List<Integer> ids = new ArrayList<>(size);
        List<Integer> scores = new ArrayList<>(size);
        List<Integer> queries = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            ids.add(i);
            scores.add(i * 10);
            queries.add(i);
        }

        List<Integer> expected = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            expected.add(i * 10);
        }

        assertEquals(expected, service.solution(ids, scores, queries));
    }
}
