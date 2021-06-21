package com.xhh.algorithm;

/**
 * @Description:
 * @Author: xhh
 * @Date: 2021/5/24 11:43
 */
public class LeeCode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.getVal() == val) {
            return root;
        } else if (root.getVal() > val) {
            return searchBST(root.getLeft(), val);
        } else {
            return searchBST(root.getRight(), val);
        }
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }
}
