package com.splabs.HackerRank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ApplesAndOrangesTest
{
    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(List<Integer> a, List<Integer> b, int exp)
    {
        int actual = ApplesAndOranges.getTotalX(a,b);
        Assertions.assertEquals(exp, actual);
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
                Arguments.of(Arrays.asList(2,4), Arrays.asList(16,32,96), 3)
        );
    }
}
