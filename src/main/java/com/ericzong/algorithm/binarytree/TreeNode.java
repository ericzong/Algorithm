package com.ericzong.algorithm.binarytree;

import java.util.LinkedList;
import java.util.function.Consumer;

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

    public void traversePreOrder(Consumer<TreeNode> op) {
        op.accept(this);
        if(this.getLeft() != null) {
            this.getLeft().traversePreOrder(op);
        }
        if(this.getRight() != null) {
            this.getRight().traversePreOrder(op);
        }
    }

    public void traversePreOrderLoop(Consumer<TreeNode> op) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode top = this;
        stack.push(null);

        while (top != null) {
            op.accept(top);
            if(top.getRight() != null) {
                stack.push(top.getRight());
            }
            if(top.getLeft() != null) {
                stack.push(top.getLeft());
            }

            top = stack.pop();
        }
    }

    public void traverseInOrder(Consumer<TreeNode> op) {
        if(this.getLeft() != null) {
            this.getLeft().traverseInOrder(op);
        }
        op.accept(this);
        if(this.getRight() != null) {
            this.getRight().traverseInOrder(op);
        }
    }

    public void traverseInOrderLoop(Consumer<TreeNode> op) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode top = this;

        while(!stack.isEmpty() || top != null) {
            if(top != null) {
                stack.push(top);
                top = top.getLeft();
            } else {
                // 左孩子节点为空返回
                top = stack.pop();
                op.accept(top);
                top = top.getRight();
            }
        }
    }

    public void traversePostOrder(Consumer<TreeNode> op) {
        if(this.getLeft() != null) {
            this.getLeft().traversePostOrder(op);
        }
        if(this.getRight() != null) {
            this.getRight().traversePostOrder(op);
        }
        op.accept(this);
    }

    public void traversePostOrderLoop(Consumer<TreeNode> op) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode top = this;
        TreeNode peek;
        TreeNode lastVisited = null;

        while(!stack.isEmpty() || top != null) {
            if(top != null) {
                stack.push(top);
                top = top.getLeft();
            } else {
                peek = stack.peek();
                if(peek.getRight() != null && lastVisited != peek.getRight()) {
                    top = peek.getRight();
                } else {
                    stack.pop();
                    op.accept(peek);
                    lastVisited = peek;
                }
            }
        }
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
