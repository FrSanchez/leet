package com.splabs.lib;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SynonymsTest {
    Synonyms s = new Synonyms();

    @Test
    public void test1() {
        List<String> syn = Arrays.asList("happy", "joyful", "glad", "happy", "sad", "sorrowful");
        s.generateSynonyms(syn, "I am happy and sad");
    }

    @Test
    public void test2() {
        List<String> syn = Arrays.asList("happy", "joyful", "glad", "happy", "sad", "sorrowful");
        s.findSynonyms(syn, "I am happy and sad");
    }
}
