package com.ericzong.algorithm.binarytree;

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private Object data;

    public TreeNode() {
    }

    public TreeNode(Object data) {
        this(null, null, data);
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this(left, right, null);
    }

    public TreeNode(TreeNode left, TreeNode right, Object data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public boolean isBalanced() {
        return isBalanced(this);
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());

        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    public int getHeight() {
        return getHeight(this);
    }

    public static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if(leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
