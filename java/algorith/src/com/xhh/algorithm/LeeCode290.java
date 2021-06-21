package com.xhh.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/21 17:41
 */
public class LeeCode290 {

    public static void main(String[] args) {

    }

    public static boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        Map<Character, String> charStr = new HashMap<>();
        Map<String, Character> strChar = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (charStr.containsKey(pattern.charAt(i))) {
                String s1 = charStr.get(pattern.charAt(i));
                if (!s1.equals(split[i])) {
                    return false;
                }
            } else {
                if (strChar.containsKey(split[i])) {
                    return false;
                }
                charStr.put(pattern.charAt(i), split[i]);
                strChar.put(split[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
