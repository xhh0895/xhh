package com.xhh.algorithm;

/**
 * @Description:
 * @Author: xhh
 * @Date: 2021/5/17 17:03
 */
public class LeeCode581 {

    /**
     * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
     *
     * @param args
     */
    public static void main(String[] args) {
        int [] nums = new int[]{2,3,3,2,4};
        System.out.println(isPossible(nums));
    }

    /**
     * 递归
     * @return
     */
    public static int isPossible(int[] nums) {
        int min = 0, max = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {
                min = i;
                break;
            }
        }
        if (nums[nums.length - 1] < nums[min]) {
            max = nums.length - 1;
        } else {
            for (int i = nums.length - 1; i > min; i--) {
                if (nums[i] < nums[i-1]) {
                    max = i;
                    break;
                }
            }
        }

        if (min != 0 || max != 0) {
            return max - min + 1;
        }
        return 0;
    }

}
