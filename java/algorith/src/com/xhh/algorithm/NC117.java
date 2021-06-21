package com.xhh.algorithm;

import java.util.Arrays;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/18 10:30
 */
public class NC117 {

    public static void main(String[] args) {
        System.out.println(solve("100"));
    }
    /**
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    public static int solve (String nums) {
        // write code here
        if (nums.length() == 0 || nums.charAt(0) == '0') return 0;
        if (nums.length() == 1) return 1;
        int pre1 = 1, pre2 = 1, cur = 0;
        for (int i = 1; i < nums.length(); i++) {
            cur = 0;
            if (nums.charAt(i) != '0') {
                if (i == 1) {
                    cur = pre1;
                } else {
                    cur = pre2;
                }
            }
            int num = (nums.charAt(i - 1) - '0') * 10 + (nums.charAt(i) - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    cur += 1;
                } else {
                    cur += pre1;
                }
            }
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }


    public int maxProfit (int[] prices) {
        // write code here
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    /**
     * 二叉树镜像
     * @param pRoot
     * @return
     */
    public static TreeNode Mirror (TreeNode pRoot) {
        // write code here
       mirror(pRoot);
       return pRoot;
    }

    public static void mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        if (pRoot.left != null || pRoot.right != null) {
            TreeNode t = pRoot.left;
            pRoot.left = pRoot.right;
            pRoot.right = t;
            mirror(pRoot.left);
            mirror(pRoot.right);
        }
    }

    /**
     * 奇偶调换
     * @param array
     * @return
     */
    public int[] reOrderArray (int[] array) {
        // write code here
        int[] dst = new int[array.length];
        int i = 0;
        for (int k = 0; k < array.length; k++) {
            if (array[k] % 2 != 0) {
                dst[i++] = array[k];
            }
        }

        for (int k = 0; k < array.length; k++) {
            if (array[k] % 2 == 0) {
                dst[i++] = array[k];
            }
        }
        return dst;
    }
}
