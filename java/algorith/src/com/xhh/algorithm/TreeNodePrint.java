package com.xhh.algorithm;

import java.util.*;

/**
 * 树的遍历
 *
 * @description:
 * @author: xhh
 * @date: 2021/6/16 16:13
 */
public class TreeNodePrint {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;
        TreeNode root3 = new TreeNode(4);
        root1.left = root3;

        levelPrint(root);
        List<Integer> integers = midPrint(root);
        System.out.println(integers);
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> prePrint(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        _prePrint(list, root);
        return list;
    }

    private static void _prePrint(List<Integer> list, TreeNode root) {
        if (root != null) {
            list.add(root.val);
            _prePrint(list, root.left);
            _prePrint(list, root.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> midPrint(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        _midPrint(list, root);
        return list;
    }

    private static void _midPrint(List<Integer> list, TreeNode root) {
        if (root == null) return;
        _midPrint(list, root.left);
        list.add(root.val);
        _midPrint(list, root.right);
    }


    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelPrint(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if (root == null)
            return list;
        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int num = deque.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
                subList.add(node.val);
            }
            list.add(subList);
        }
        return list;
    }
}
