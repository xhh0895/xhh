package com.xhh.algorithm.tencent;

import java.util.Scanner;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/17 16:51
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int res = func(n, m);
        System.out.println(res);
    }

    private static int func(int n, int m) {
        int start = 1, end = m;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            int eat = eatMax(mid, n);
            if (eat == m) {
               return mid;
            } else if (eat < m) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    public static int eatMax(int maxEat, int days) {
        int total = 0;
        for (int i = 1; i <= days; i++) {
            total += maxEat;
            maxEat = (maxEat +1) /2 ;
        }
        return total;
    }
    public static int binSearch(int target, int[] nums) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end) /2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return -1;
    }
}
