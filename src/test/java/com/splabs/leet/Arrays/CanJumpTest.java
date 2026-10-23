package com.splabs.leet.Arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanJumpTest {
    @ParameterizedTest
    @MethodSource("testProvider")
    public void test(int[] nums, boolean expected) {
        var sol = new CanJump();
        boolean actual = sol.canJump(nums);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> testProvider() {
        return Stream.of(
                Arguments.of(new int[]{2,3,1,1,4}, true),
                Arguments.of(new int[]{3,2,1,0,4}, false),
                Arguments.of(new int[]{0}, true)
        );
    }
}
