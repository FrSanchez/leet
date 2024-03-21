package com.splabs.meta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhotographyTest {
    private Photography photography;
    @BeforeEach
    public void init() {
        photography = new Photography();
    }

    @ParameterizedTest
    @MethodSource("photoProvider")
    public void removeK(int N, String C, int X, int Y, int expected) {
        int actual = photography.getArtisticPhotographCount(5, "APABA", 1, 2);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> photoProvider() {
        return Stream.of(
                Arguments.of(5, "APABA", 1, 2, 1),
                Arguments.of(5, "APABA", 2, 3, 0),
                Arguments.of(8, ".PBAAP.B", 1, 3, 3)
        );
    }
}
