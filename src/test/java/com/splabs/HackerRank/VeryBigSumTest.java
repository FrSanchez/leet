package com.splabs.HackerRank;

import com.splabs.lib.Combinations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class VeryBigSumTest {
    @ParameterizedTest
    @MethodSource("removeKProvider")
    public void testMinMax(List<Integer> arr) {
        aVeryBigSum.miniMaxSum(arr);
    }

    static Stream<Arguments> removeKProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(793810624, 895642170, 685903712, 623789054, 468592370))
        );
    }
}
