package com.xhh.od;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/19 15:21
 */
public class Test01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] split = line.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                int n = Integer.parseInt(split[i]);
                nums[i] = n;
            } catch (Exception e) {
                System.out.println("[]");
                return;
            }
        }

        int[] solve = solve(nums);
        if (solve != null && solve.length > 0) {
            for (int i = 0; i < solve.length - 1; i++) {
                System.out.print(solve[i] + " ");
            }
            System.out.println(solve[solve.length - 1]);
        }
    }


    public static int[] solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        boolean up = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (up) { // 下一个比当前小，否则交换
                if (nums[i + 1] > nums[i]) {
                    int t = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = t;
                }
            } else { // 下一个比当前大，否则交换
                if (nums[i + 1] < nums[i]) {
                    int t = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = t;
                }
            }
            up = !up;
        }
        return nums;
    }
}
