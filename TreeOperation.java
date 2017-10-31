package com.example.tree;

/**
 * Created by xingwei on 2017/10/31.
 */
public class TreeOperation {

    public static BasicTree buildOneTree() {
        BasicTree binTree = new BasicTree<String>("根节点");
        // 依次添加节点
        BasicTree.TreeNode tn1 = binTree.add(binTree.getRoot(), "第二层左节点", true);
        BasicTree.TreeNode tn2 = binTree.add(binTree.getRoot(), "第二层右节点", false);
        BasicTree.TreeNode tn3 = binTree.add(tn2, "第三层左节点", true);
        BasicTree.TreeNode tn4 = binTree.add(tn2, "第三层右节点", false);
        BasicTree.TreeNode tn5 = binTree.add(tn3, "第四层左节点", true);
        return binTree;
    }

    //前序遍历
    public static void pre(BasicTree.TreeNode root) {

        if (root == null) {
            return;
        }
        System.out.println(root.getData());
        pre(root.getLeft());
        pre(root.getRight());
    }

    //中序遍历
    public static void mid(BasicTree.TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.getLeft());
        System.out.println(root.getData());
        mid(root.getRight());
    }

    //后序遍历
    public static void post(BasicTree.TreeNode root) {
        if (root == null) {
            return;
        }
        post(root.getLeft());
        post(root.getRight());
        System.out.println(root.getData());
    }
}
