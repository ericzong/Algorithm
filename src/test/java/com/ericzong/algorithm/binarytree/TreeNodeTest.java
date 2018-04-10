package com.ericzong.algorithm.binarytree;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TreeNodeTest {
    @Test
    public void testStaticGetHeight() {
        TreeNode right = new TreeNode();
        TreeNode left = new TreeNode(null, right);
        TreeNode root = new TreeNode(left, null);

        Assert.assertEquals(TreeNode.getHeight(root), 3);
        Assert.assertEquals(TreeNode.getHeight(left), 2);
        Assert.assertEquals(TreeNode.getHeight(right), 1);
        Assert.assertEquals(TreeNode.getHeight(null), 0);
    }

    @Test
    public void testGetHeight() {
        TreeNode right = new TreeNode();
        TreeNode left = new TreeNode(null, right);
        TreeNode root = new TreeNode(left, null);

        Assert.assertEquals(root.getHeight(), 3);
        Assert.assertEquals(left.getHeight(), 2);
        Assert.assertEquals(right.getHeight(), 1);
    }

    @Test
    public void testStaticIsBalancedNullRoot() {
        Assert.assertTrue(TreeNode.isBalanced(null));
    }

    @Test
    public void testStaticIsBalancedSingleRoot() {
        Assert.assertTrue(TreeNode.isBalanced(new TreeNode()));
    }

    @Test
    public void testStaticIsBalancedTrue() {
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        TreeNode root = new TreeNode(left, right);

        Assert.assertTrue(TreeNode.isBalanced(root));
    }

    @Test
    public void testStaticIsBalancedFalse() {
        TreeNode right = new TreeNode();
        TreeNode left = new TreeNode(null, right);
        TreeNode root = new TreeNode(left, null);

        Assert.assertFalse(TreeNode.isBalanced(root));
    }

    @Test
    public void testIsBalancedSingleRoot() {
        Assert.assertTrue(new TreeNode().isBalanced());
    }

    @Test
    public void testIsBalancedTrue() {
        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();
        TreeNode root = new TreeNode(left, right);

        Assert.assertTrue(root.isBalanced());
    }

    @Test
    public void testIsBalancedFalse() {
        TreeNode right = new TreeNode();
        TreeNode left = new TreeNode(null, right);
        TreeNode root = new TreeNode(left, null);

        Assert.assertFalse(root.isBalanced());
    }
}
