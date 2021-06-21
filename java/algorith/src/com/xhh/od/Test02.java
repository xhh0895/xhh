package com.xhh.od;

import java.util.Scanner;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/19 15:54
 */
public class Test02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int n = in.nextInt();
        // 身高数组
        int[][] stus = new int[n][3];

        for (int i = 0; i < n; i++) {
            stus[i][0] = in.nextInt();
            stus[i][1] = Math.abs(stus[i][0] - h);
            stus[i][2] = i;
        }
        // 遍历记录身高差，排序记录下标
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stus[i][1] > stus[j][1]) {
                    int[] t = stus[i];
                    stus[i] = stus[j];
                    stus[j] = t;
                }
            }
        }
        // 将身高差一样的以身高低的在前排序
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stus[i][1] == stus[j][1] && stus[i][0] > stus[j][0]) {
                    int[] t = stus[i];
                    stus[i] = stus[j];
                    stus[j] = t;
                }
            }
        }
        // 按下标顺序输出结果
        for (int i = 0; i < n - 1; i++) {
            System.out.print(stus[i][0] + " ");
        }
        System.out.println(stus[n - 1][0]);

    }
}
