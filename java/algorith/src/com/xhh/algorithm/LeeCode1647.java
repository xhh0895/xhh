package com.xhh.algorithm;

import java.util.*;

/**
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 * 示例 1：
 * 输入：s = "aab"
 * 输出：0
 * 解释：s 已经是优质字符串。
 */
public class LeeCode1647 {

    public static int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Integer integer = map.get(s.charAt(i));
                map.put(s.charAt(i), integer +1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        if (map.size() == 1) {
            return 0;
        }

        // 保证values中没有重复的值，最少需要删除几个元素
        List<Integer> list = new ArrayList(map.values());
        Collections.sort(list);

        int count = 0;
        for (int i = 0; i < list.size() - 1; ) {
            int cur = list.get(i);
            int next = list.get(i +1);
            if (cur == next && cur > 0) {
                list.set(i, cur - 1);
                System.out.println(list);
                count++;
                i = 0;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minDeletions("bbcebab"));
    }
}
