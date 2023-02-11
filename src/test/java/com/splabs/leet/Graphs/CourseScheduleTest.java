package com.splabs.leet.Graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseScheduleTest {

    CourseSchedule sc;
    @BeforeEach
    public void init() {
        sc = new CourseSchedule();
    }

    @ParameterizedTest
    @MethodSource("scheduleProvider")
    public void testSchedule(int num, int [][] prerequisites, boolean canFinish)
    {
        boolean can = sc.canFinish(num, prerequisites);
        assertEquals(canFinish, can);
        List<String> change = new ArrayList<>();

    }

    static Stream<Arguments> scheduleProvider() {
        return Stream.of(
                Arguments.of(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}, true),
                Arguments.of(1, new int[][]{}, true),
                Arguments.of(2, new int[][]{}, true),
                Arguments.of(2, new int[][]{{1, 0}}, true),
                Arguments.of(2, new int[][]{{1, 0}, {0, 1}}, false)
        );
    }
}
