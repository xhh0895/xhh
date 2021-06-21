package com.xhh.algorithm.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 数组交集
 * @Author: xhh
 * @Date: 2021/2/24 14:36
 */
public class Intersect {

    public static int[] solution1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int a : nums1) {
            m.put(a, !m.containsKey(a) ? 1 : 1 + m.get(a));
        }

        int k = 0;
        for (int b : nums2) {
            if (!m.containsKey(b)) {
                m.remove(b);
            }
            if (m.containsKey(b)) {
                m.put(b, m.get(b) - 1);
                nums2[k++] = b;
            }
            if (m.get(b) <= 0) {
                m.remove(b);
            }
        }
        return Arrays.copyOfRange(nums2, 0, k);
    }
}
