package com.xhh.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/8 18:32
 */
public class LeeCode217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if(set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }
}
