package com.xhh.algorithm;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/18 14:02
 */
public class NC98 {

    /**
     * 二叉树子树
     * @param root1
     * @param root2
     * @return
     */
    public boolean isContains (TreeNode root1, TreeNode root2) {
        // write code here
        return false;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;
        TreeNode root3 = new TreeNode(4);
        root1.left = root3;
        TreeNode treeNode = mergeTrees(root, root2);
        System.out.println(treeNode);
    }
    /**
     * 合并2叉树
     * @param t1
     * @param t2
     * @return
     */
    public static TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null && t2 == null) return null;
        if (t1 == null || t2 == null) return t1 == null ? t2 : t1;
        // 此时 t1、t2 均不为 null
        // 合并节点的值
        t1.val = t1.val + t2.val;
        // 合并左子树
        t1.left = mergeTrees(t1.left, t2.left);
        // 合并右子树
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }


}
