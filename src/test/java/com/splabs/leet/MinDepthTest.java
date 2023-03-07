package com.splabs.leet;

import org.junit.jupiter.api.Test;

public class MinDepthTest {
    @Test
    public void test1() {
        MinDepth md = new MinDepth();
        TreeNode root = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));

        md.minDepth(root);
    }
}
