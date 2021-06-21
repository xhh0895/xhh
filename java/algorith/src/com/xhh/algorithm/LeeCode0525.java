package com.xhh.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 * 示例 1:
 * 输入: [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * @Description:
 * @Author: xhh
 * @Date: 2021/5/24 11:19
 */
public class LeeCode0525 {

    /**
     * 记录所有count的位置
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, maxLen = 0;
        for (int i = 0 ;i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int maxLength = LeeCode0525.findMaxLength(new int[]{1, 0, 1, 1, 0, 1, 1, 1});
        System.out.println(maxLength);
    }
}
