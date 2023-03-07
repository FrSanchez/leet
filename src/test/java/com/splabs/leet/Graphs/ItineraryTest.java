package com.splabs.leet.Graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItineraryTest {
    @ParameterizedTest
    @MethodSource("itineraryProvider")
    public void testItinerary(String[][] edges, List<String> expected) {
        Itinerary it = new Itinerary();
        List<String> output = it.findItinerary(arrayToList(edges));
        assertEquals(expected.size(), output.size());
        for(int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), output.get(i));
        }
    }

    static List<List<String>> arrayToList(String[][] array) {
        List<List<String>> list = new ArrayList<>();
        for(String[] edge : array) {
            list.add( Arrays.stream(edge).collect(Collectors.toList()));
        }
        return list;
    }

    static Stream<Arguments> itineraryProvider() {
        return Stream.of(
                Arguments.of(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}},
                        Arrays.asList( "JFK","MUC","LHR","SFO","SJC"))
        );
    }
}
