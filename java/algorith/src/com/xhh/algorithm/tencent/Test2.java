package com.xhh.algorithm.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/17 16:43
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        int sum = 0;
        for (int i = n -1; i >= 0; i-=2) {
            sum += nums[i] - (i == 0 ? 0 : nums[i - 1]);
        }
        System.out.println(sum);
    }
}
