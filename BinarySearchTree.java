package com.example.tree;

import lombok.Getter;

/**
 * Created by xingwei on 2017/10/31.
 */
public class BinarySearchTree extends BasicTree<Integer> {
    @Getter
    private BinarySearchTree.TreeNode root = new BinarySearchTree.TreeNode();

    //添加一个节点
    public void insert(Integer data) {
        if (root == null || root.getData() == null) {
            root = new BinarySearchTree.TreeNode(data);
            return;
        }
        add(data, root);
    }

    private void add(Integer data, BinarySearchTree.TreeNode node) {
        if (data > (Integer) node.getData()) {
            if (node.getRight() == null) {
                BinarySearchTree.TreeNode newNode = new BinarySearchTree.TreeNode(data);
                node.setRight(newNode);
                newNode.setParent(node);
            } else {
                add(data, node.getRight());
            }
        } else if (data < (Integer) node.getData()) {
            if (node.getLeft() == null) {
                BinarySearchTree.TreeNode newNode = new BinarySearchTree.TreeNode(data);
                node.setLeft(newNode);
                newNode.setParent(node);
            } else {
                add1(data, node.getLeft());
            }
        }
    }

    //非递归
    private void add1(Integer data, BinarySearchTree.TreeNode node) {
        while (node != null) {
            if (data > (Integer) node.getData()) {
                if (node.getRight() == null) {
                    BinarySearchTree.TreeNode newNode = new BinarySearchTree.TreeNode(data);
                    node.setRight(newNode);
                    newNode.setParent(node);
                    break;
                }
                node = node.getRight();
            } else if (data < (Integer) node.getData()) {
                if (node.getLeft() == null) {
                    BinarySearchTree.TreeNode newNode = new BinarySearchTree.TreeNode(data);
                    node.setLeft(newNode);
                    newNode.setParent(node);
                    break;
                }
                node = node.getLeft();
            }
        }
    }

    //删除一个节点

    //前序遍历
    public void pre(BinarySearchTree.TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.println((Integer) node.getData());
        pre(node.getLeft());
        pre(node.getRight());
    }

    //中序遍历
    public void mid(BinarySearchTree.TreeNode node) {
        if (node == null) {
            return;
        }

        mid(node.getLeft());
        System.out.println((Integer) node.getData());
        mid(node.getRight());
    }

    //后序遍历
    public void post(BinarySearchTree.TreeNode node) {
        if (node == null) {
            return;
        }

        post(node.getLeft());
        post(node.getRight());
        System.out.println((Integer) node.getData());
    }

    //max element
    public Integer findMax(BinarySearchTree.TreeNode node) {
        if (node == null) {
            throw new RuntimeException("");
        }
        Integer max = (Integer) node.getRight().getData();
        while (node.getRight() != null) {
            max = (Integer) node.getRight().getData();
            node = node.getRight();
        }
        return max;
    }

    //min element

    public Integer findMin(BinarySearchTree.TreeNode node) {
        if (node == null) {
            throw new RuntimeException("");
        }
        Integer min = (Integer) node.getLeft().getData();
        while (node.getLeft() != null) {
            min = (Integer) node.getLeft().getData();
            node = node.getLeft();
        }
        return min;
    }

    //是否包含特定元素data
    public boolean exsit(Integer data, BinarySearchTree.TreeNode node) {
        if (node == null) {
            return false;
        }
        if (data > (Integer) node.getData()) {
            return exsit(data, node.getRight());
        } else if (data < (Integer) node.getData()) {
            return exsit(data, node.getLeft());
        } else if (data.intValue() == ((Integer) node.getData()).intValue()) {
            return true;
        }
        return false;
    }

    //查找特定元素
    public TreeNode search(Integer data, BinarySearchTree.TreeNode node) {
        if (node == null) {
            return null;
        }
        if (data > (Integer) node.getData()) {
            return search(data, node.getRight());
        } else if (data < (Integer) node.getData()) {
            return search(data, node.getLeft());
        } else if (data.intValue() == ((Integer) node.getData()).intValue()) {
            return node;
        }
        return null;
    }
}
