package com.splabs.Questions;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class NoteTaking {
    public void m1(int[] array) {
        Map<Integer, Long> freq = Arrays.stream(array).boxed().
                collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
    }
}
