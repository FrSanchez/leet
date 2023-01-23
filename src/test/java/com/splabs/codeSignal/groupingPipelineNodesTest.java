package com.splabs.codeSignal;

import org.junit.jupiter.api.Test;

public class groupingPipelineNodesTest {
    @Test
    public void test() {
        groupingPipelineNodes gpn = new groupingPipelineNodes();
        gpn.solution(6, new int[][] {{1,2}, {2,3}, {2,4}, {2,5}, {4,6}, {5,6}}, new int[] {4, 5});
    }
}
