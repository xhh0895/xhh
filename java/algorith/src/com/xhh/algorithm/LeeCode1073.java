package com.xhh.algorithm;

/**
 * 给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
 * 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。
 * 例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。
 * 数组形式 的数字也同样不含前导零：以 arr 为例，这意味着要么 arr == [0]，要么 arr[0] == 1。
 * 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。

 * @description:
 * @author: xhh
 * @date: 2021/6/15 13:42
 */
public class LeeCode1073 {

    public static int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        int max = Math.max(i , j) + 1;
        int[] res = new int[max];
        while (i >= 0 || j >= 0) {

        }
        return null;
    }
}
