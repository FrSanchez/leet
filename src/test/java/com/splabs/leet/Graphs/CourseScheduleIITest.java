package com.splabs.leet.Graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class CourseScheduleIITest {
    CourseScheduleII sched;

    @BeforeEach
    public void init() {
        sched = new CourseScheduleII();
    }

    @ParameterizedTest
    @MethodSource("courseProvider")
    public void test(int n, int[][] prereq) {
        int[] order = sched.findOrder(n, prereq);
        System.out.println(Arrays.toString(order));

    }

    static Stream<Arguments> courseProvider() {
        return Stream.of(
                Arguments.of(4, (Object) new int[][]{{0, 1}, {3, 1}, {1, 3}, {3, 2}}),
                Arguments.of(2, (Object) new int[][]{{1, 0}, {0, 1}}),
                Arguments.of(2, (Object) new int[][]{{1, 0}}),
                Arguments.of(4, (Object) new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})
        );
    }
}