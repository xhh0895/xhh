package com.xhh.algorithm;

import java.util.Arrays;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/15 14:15
 */
public class LeeCode1619 {

    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int sub = arr.length * 5 / 100;
        int sum = 0;
        for (int i = sub; i < arr.length - sub; i++) {
            sum += arr[i];
        }
        return (double)sum / (arr.length - 2 * sub);
    }

    public static void main(String[] args) {
        System.out.println(trimMean(new int[]{6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0}));
    }
}
