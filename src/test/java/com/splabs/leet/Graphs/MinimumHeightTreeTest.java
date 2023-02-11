package com.splabs.leet.Graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumHeightTreeTest {
    MinimumHeightTree mht;

    @BeforeEach
    public void init() {
        mht = new MinimumHeightTree();
    }

    @ParameterizedTest
    @MethodSource("heightProvider")
    public void testGetHeight(int[][] edges, int root, int height) {
        int actual = mht.dfsForMaxDepth(root, mht.buildGraph(edges));
        assertEquals(height, actual);
    }

    @ParameterizedTest
    @MethodSource("mhtProvider")
    public void testMHT(int[][] edges, int[] expected) {
        List<Integer> sol = mht.findMinHeightTrees(edges.length, edges);
        int[] actual = new int[sol.size()];
        int i = 0;
        for(int n : sol) {
            actual[i] = n;
            i++;
        }
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> mhtProvider() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{1, 0}, {1, 2}, {1, 3}}, new int[] {1}),
                Arguments.of((Object)new int[][] {{3,0},{3,1},{3,2},{3,4},{5,4}}, new int[]{3,4})
        );
    }

    static Stream<Arguments> heightProvider() {
        return Stream.of(
                Arguments.of((Object) new int[][]{{1, 0}, {1, 2}, {1, 3}}, 0, 3),
                Arguments.of((Object) new int[][]{{1, 0}, {1, 2}, {1, 3}}, 1, 2),
                Arguments.of((Object) new int[][]{{1, 0}, {1, 2}, {1, 3}}, 2, 3),
                Arguments.of((Object) new int[][]{{1, 0}, {1, 2}, {1, 3}}, 3, 3)
        );
    }
}
