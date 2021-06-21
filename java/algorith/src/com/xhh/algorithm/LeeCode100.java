package com.xhh.algorithm;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/15 11:53
 */
public class LeeCode100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
