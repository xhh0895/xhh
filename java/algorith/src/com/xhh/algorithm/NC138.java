package com.xhh.algorithm;

import java.util.Arrays;

/**
 * @description: 矩阵最长路径
 * @author: xhh
 * @date: 2021/6/18 16:08
 */
public class NC138 {

    public static void main(String[] args) {
        System.out.println(solve(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
    public static int solve(int[][] matrix) {
        // write code here
        int max = 0;
        int[][] path = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(path[i], 0);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                path[i][j] = dfs(matrix, path, i, j, -1);
                if (path[i][j] > max) {
                    max = path[i][j];
                }
            }
        }
        return max;
    }

    public static int dfs(int[][] matrix, int[][] path, int i, int j, int pre) {
        if (matrix[i][j] <= pre) {
            return 0;
        }
        if (path[i][j] != 0) {
            return path[i][j];
        }
        int max = 0;
        // 向上判断1次
        if (i > 0) {
           max = Math.max(max, dfs(matrix, path,i - 1, j, matrix[i][j]));
        }
        // 向左
        if (j > 0) {
            max = Math.max(max, dfs(matrix,path, i, j - 1, matrix[i][j]));
        }
        // 向下
        if (i < matrix.length - 1) {
            max = Math.max(max, dfs(matrix,path, i + 1, j, matrix[i][j]));
        }
        // 向右
        if (j < matrix[i].length - 1) {
            max = Math.max(max, dfs(matrix,path, i, j + 1, matrix[i][j]));
        }
        return max + 1;
    }


}
