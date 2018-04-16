package com.ericzong.algorithm.binarytree;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNodeTest {
    @Test(dataProvider = "data")
    public void testTraversePreOrder(TreeNode root) {
        List<String> queue = new ArrayList<>();
        root.traversePreOrder(e -> queue.add(e.getData().toString()));

        Assert.assertEquals(queue, Arrays.asList(new String[]{"A", "B", "D", "C", "E"}));
    }

    @Test(dataProvider = "data")
    public void testTraversePreOrderLoop(TreeNode root) {
        List<String> queue = new ArrayList<>();
        root.traversePreOrderLoop(e -> queue.add(e.getData().toString()));

        Assert.assertEquals(queue, Arrays.asList(new String[]{"A", "B", "D", "C", "E"}));
    }

    @Test(dataProvider = "data")
    public void testTraverseInOrder(TreeNode root) {
        List<String> queue = new ArrayList<>();
        root.traverseInOrder(e -> queue.add(e.getData().toString()));

        Assert.assertEquals(queue, Arrays.asList(new String[]{"B", "D", "A", "E", "C"}));
    }

    @Test(dataProvider = "data")
    public void testTraverseInOrderLoop(TreeNode root) {
        List<String> queue = new ArrayList<>();
        root.traverseInOrderLoop(e -> queue.add(e.getData().toString()));

        Assert.assertEquals(queue, Arrays.asList(new String[]{"B", "D", "A", "E", "C"}));
    }

    @Test(dataProvider = "data")
    public void testTraversePostOrder(TreeNode root) {
        List<String> queue = new ArrayList<>();
        root.traversePostOrder(e -> queue.add(e.getData().toString()));

        Assert.assertEquals(queue, Arrays.asList(new String[]{"D", "B", "E", "C", "A"}));
    }

    @Test(dataProvider = "data")
    public void testTraversePostOrderLoop(TreeNode root) {
        List<String> queue = new ArrayList<>();
        root.traversePostOrderLoop(e -> queue.add(e.getData().toString()));

        Assert.assertEquals(queue, Arrays.asList(new String[]{"D", "B", "E", "C", "A"}));
    }

    @Test(dataProvider = "data")
    public void testTraverseLevelOrder(TreeNode root) {
        List<String> queue = new ArrayList<>();
        root.traverseLevelOrder(e -> queue.add(e.getData().toString()));

        Assert.assertEquals(queue, Arrays.asList(new String[]{"A", "B", "C", "D", "E"}));
    }

    /**
     *         A
     *       /   \
     *     B      C
     *       \   /
     *        D E
     */
    @DataProvider(name = "data")
    public Object[][] getData() {
        TreeNode eNode = new TreeNode("E");
        TreeNode dNode = new TreeNode("D");
        TreeNode bNode = new TreeNode(null, dNode, "B");
        TreeNode cNode = new TreeNode(eNode, null, "C");
        TreeNode root = new TreeNode(bNode, cNode, "A");

        return new Object[][]{{root}};
    }

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
