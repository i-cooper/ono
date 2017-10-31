package com.example.tree;

import lombok.Data;

/**
 * Created by xingwei on 2017/10/31.
 */
public class BasicTree<T> {
    @Data
    static class TreeNode {
        private Object data;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode() {

        }

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right, TreeNode parent) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public String toString(){
            return "data: "+data+" parent "+parent;
        }
    }

    private TreeNode root;

    public BasicTree() {
        this.root = new TreeNode();
    }

    public BasicTree(T data) {
        this.root = new TreeNode(data);
    }

    public boolean isEmpty() {
        if (root.data == null) {
            return true;
        }
        return false;
    }

    public TreeNode getRoot() {
        if (isEmpty()) {
            return null;
        }
        return root;
    }

    public T getParent(TreeNode node) {
        if (node == null) {
            throw new RuntimeException("node is null");
        }
        return (T) node.parent.data;
    }

    public T getLeftChild(TreeNode node) {
        if (node == null) {
            throw new RuntimeException("node is null");
        }
        if (node.left == null) {
            throw new RuntimeException("node left is null");
        }
        return (T) node.left.data;
    }

    public T getRightChild(TreeNode node) {
        if (node == null) {
            throw new RuntimeException("node is null");
        }
        if (node.right == null) {
            throw new RuntimeException("node right is null");
        }
        return (T) node.right.data;
    }

    public int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            int deepLeft = deep(node.left);
            int deepRight = deep(node.right);
            return deepLeft > deepRight ? deepLeft + 1 : deepRight + 1;
        }
    }

    public TreeNode add(TreeNode parent, T data, boolean isLeft) {
        if (parent == null || data == null) {
            throw new NullPointerException("add fail. cause::null");
        }
        TreeNode newNode = new TreeNode(data);
        if (isLeft) {
            if (parent.left != null) {
                throw new RuntimeException(" parent left child already exist");
            }
            parent.left = newNode;
        } else {
            if (parent.right != null) {
                throw new RuntimeException(" parent right child already exist");
            }
            parent.right = newNode;
        }
        newNode.parent = parent;
        return newNode;
    }
}
