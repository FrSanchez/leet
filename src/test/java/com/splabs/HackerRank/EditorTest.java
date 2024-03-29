package com.splabs.HackerRank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class EditorTest {
    @ParameterizedTest
    @MethodSource("test1Provider")
    public void tes1(List<String> ops, List<String> exp)
    {
        Editor editor = new Editor();
        List<String> actual = new ArrayList<>();
        for(String op : ops) {
            String result = editor.editor(op);
            if (!result.equalsIgnoreCase("")){
                actual.add(result);
            }
        }
        Assertions.assertEquals(exp.size(), actual.size());
        for(int i = 0; i < exp.size(); i++) {
            Assertions.assertEquals(exp.get(i), actual.get(i));
        }
    }

    static Stream<Arguments> test1Provider() {
        return Stream.of(
                Arguments.of(Arrays.asList("1 abc",
                        "3 3",
                        "2 3",
                        "1 xy",
                        "3 2",
                        "4",
                        "4",
                        "3 1"), Arrays.asList("c",
                        "y",
                        "a"))
        );
    }
}
