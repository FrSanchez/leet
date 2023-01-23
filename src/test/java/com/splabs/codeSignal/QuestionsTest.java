package com.splabs.codeSignal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class QuestionsTest {

    private Questions questions;

    @BeforeEach
    public void init()
    {
        questions = new Questions();
    }

    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(String test, String exp)
    {
        questions.tetris(new int[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {1, 0, 0}, {1, 1, 0}}, 
        new int[][]{{0, 0, 1}, {0, 1, 1}, {0, 0, 1}}  );
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
            Arguments.of("12:00:00AM", "00:00:00")
        );
    }

    @ParameterizedTest
    @MethodSource("test2Provider")
    public void tes2(String test, String exp)
    {
    }

    static Stream<Arguments> test2Provider() {
        return Stream.of(
            Arguments.of("12:00:00AM", "00:00:00")
        );
    }

    @ParameterizedTest
    @MethodSource("test3Provider")
    public void test3(String test, String exp)
    {
    }

    static Stream<Arguments> test3Provider() {
        return Stream.of(
            Arguments.of("12:00:00AM", "00:00:00")
        );
    }

    @ParameterizedTest
    @MethodSource("test4Provider")
    public void tes4(String test, String exp)
    {
    }

    static Stream<Arguments> test4Provider() {
        return Stream.of(
            Arguments.of("12:00:00AM", "00:00:00")
        );
    }

    @Test
    public void testInterest() 
    {

        assertEquals(3, questions.interest(100, 20, 170));
    }
}
