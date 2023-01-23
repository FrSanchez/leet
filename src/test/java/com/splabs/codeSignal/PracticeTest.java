package com.splabs.codeSignal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PracticeTest {

    private Practice pr;
    @BeforeEach
    public void init() 
    {
        pr = new Practice();
    }
    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(int[] a, int k, int cnt)
    {
        int c = pr.ribbons(a, k);
        assertEquals(cnt, c);
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
            Arguments.of(new int[] {5, 2, 7, 4, 9}, 5, 4),
            Arguments.of(new int[] {1, 2, 3, 4, 9}, 6, 2)
        );
    }

}
