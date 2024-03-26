package com.splabs.HackerRank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class DNAHealthTest {
    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(List<String> input) throws IOException {
        DNAHealth.CalculateHealth(input);
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
                Arguments.of(Arrays.asList("6",
                        "a b c aa d b",
                        "1 2 3 4 5 6",
                        "3",
                        "1 5 caaab",
                        "0 4 xyz",
                        "2 4 bcdybc"))
        );
    }

    @ParameterizedTest
    @MethodSource("fileProvider")
    public void testWithFile(String file) throws IOException {
        DNAHealth.LoadFromFile(file);
    }

    static Stream<Arguments> fileProvider() {
        return Stream.of(
                Arguments.of("dna2.test.txt"),
                Arguments.of("dna1.test.txt")

        );
    }
}
