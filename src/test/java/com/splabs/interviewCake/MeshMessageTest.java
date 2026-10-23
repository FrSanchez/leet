package com.splabs.interviewCake;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeshMessageTest {
    @ParameterizedTest
    @MethodSource("test1Provider")
    public void test(List<List<String>> network, String from, String to, List<String> expected) {
        MeshMessage meshMessage = new MeshMessage();
        List<String> actual = meshMessage.shortestRoute(network, from, to);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> test1Provider() {
        List<List<String>> network = List.of(
                List.of("Min", "William", "Jayden", "Omar"),
                List.of("William", "Min", "Noam"),
                List.of("Jayden", "Min", "Amelia", "Ren", "Noam"),
                List.of("Ren", "Jayden", "Omar"),
                List.of("Amelia", "Jayden", "Adam", "Miguel"),
                List.of("Adam", "Amelia", "Miguel", "Sofia", "Lucas"),
                List.of("Miguel", "Amelia", "Adam", "Liam", "Nathan"),
                List.of("Noam", "Nathan", "Jayden", "William"),
                List.of("Omar", "Ren", "Min", "Scott")
        );
        List<String> expected = List.of("Jayden", "Amelia", "Adam");

        return Stream.of(
                Arguments.of(network, "Jayden", "Adam", expected),
                Arguments.of(network, "Ren", "Omar", List.of("Ren", "Omar")),
                Arguments.of(network, "Omar", "Mary", null)
        );
    }
}
