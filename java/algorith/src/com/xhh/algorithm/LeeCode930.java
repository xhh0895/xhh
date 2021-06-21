package com.xhh.algorithm;

/**
 * @Description:
 * @Author: xhh
 * @Date: 2021/5/24 12:00
 */
public class LeeCode930 {

    /**
     * 暴力循环法
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) {
                    System.out.println("start = " + i + ",end = " + j);
                    total++;
                    if (j != nums.length - 1 && nums[j + 1] != 0) {
                        break;
                    }
                }
            }
        }
        return total;
    }
    
    public static void main(String[] args) {
        int a = numSubarraysWithSum(new int[]{1,0,1,0,1}, 2);
        System.out.println(a);
    }
}
