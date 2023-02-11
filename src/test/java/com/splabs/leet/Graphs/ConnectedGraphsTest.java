package com.splabs.leet.Graphs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ConnectedGraphsTest {

    private Node loadNode(int[][] edges) {
        Map<Integer, Node> nodes = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            if (!nodes.containsKey(i + 1)) {
                nodes.put(i + 1, new Node(i + 1));
            }
            for(int e : edges[i]) {
                if (!nodes.containsKey(e)) {
                    nodes.put(e, new Node(e));
                }
                nodes.get(i + 1).neighbors.add(nodes.get(e));

            }
        }
        return nodes.get(1);
    }
    @ParameterizedTest
    @MethodSource("copyProvider")
    public void testCopy(int[][] edges)
    {
        ConnectedGraphs g = new ConnectedGraphs();
        Node actual = g.cloneGraph(loadNode(edges));
    }

    static Stream<Arguments> copyProvider() {
        return Stream.of(
                Arguments.of((Object) new int[][] {{2,4},{1,3},{2,4},{1,3}})
        );
    }
}
