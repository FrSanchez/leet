package com.splabs.codeSignal;

import org.junit.jupiter.api.Test;

import java.util.List;

public class AlphaLandTest {
    @Test
    public void sampleTest() {
        var al = new Alphaland();
        List<Integer> actual = al.solution("abacdcd");
        System.out.println(actual);
    }
}
