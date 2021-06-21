package com.xhh.algorithm.od;

import java.util.Arrays;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/21 18:27
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(minSum(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3, 4}));
    }
    public static int minSum(int[] nums) {
        int[] tm1 = new int[5];
        int[] tm2 = new int[5];
        int t1 = 0, t2 = 0;

        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += nums[i];
        }
//        int avg =  total / 2;
        float avg = (float) total / 10;
        float[][] dicSort = new float[10][3];
        for (int i = 0; i < 10; i++) {
            dicSort[i][0] = Math.abs(nums[i] - avg);
            dicSort[i][1] = i;
            dicSort[i][2] = nums[i];
        }
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (dicSort[i][0] > dicSort[j][0]) {
                    float[] t = dicSort[i];
                    dicSort[i] = dicSort[j];
                    dicSort[j] = t;
                }
            }
        }
        System.out.println(dicSort);

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < 10; i++) {
            if (cnt1 <= cnt2) {
                cnt1 += dicSort[i][2];
                tm1[t1++] = (int) dicSort[i][2];
            } else {
                cnt2 += dicSort[i][2];
                tm2[t2++] = (int) dicSort[i][2];
            }
        }

        System.out.println(Math.abs(cnt1 - cnt2));
        return Math.abs(cnt1 - cnt2);
    }
}
