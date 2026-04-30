package com.splabs.lib;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import java.util.List;

public class EventsTest {
    @Test
    public void testDeDup() {
        Events e = new Events(10);
        assertTrue(e.addEvent(1, 1));
        assertTrue(e.addEvent(2, 2));
        assertTrue(e.addEvent(3, 3));
        assertTrue(e.addEvent(4, 4));
        assertFalse(e.addEvent(1, 10));
        System.out.println(e.getEvents(6));
    }

    @Test
    public void validDupe() {
        Events e = new Events(10);
        assertTrue(e.addEvent(1, 1));
        assertTrue(e.addEvent(2, 2));
        assertTrue(e.addEvent(3, 3));
        assertTrue(e.addEvent(4, 4));
        assertTrue(e.addEvent(1, 12));
        System.out.println(e.getEvents(11));
    }
//    @ParameterizedTest
//    @MethodSource("removeKProvider")
//    public void testAllStrings(String input)
//    {
//        Combinations c = new Combinations();
//        List<String> combinations = c.allStrings(input);
//        System.out.println(combinations);
//    }
//
//    static Stream<Arguments> removeKProvider() {
//        return Stream.of(
//                Arguments.of("a"),
//                Arguments.of("ab"),
//                Arguments.of("abc"),
//                Arguments.of("aabb")
//        );
//    }
}
