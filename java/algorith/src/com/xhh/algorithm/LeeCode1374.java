package com.xhh.algorithm;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/15 10:38
 */
public class LeeCode1374 {

    public static String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        if (n % 2 == 0) {
            for (int i = 0; i < n - 1; i++) {
                sb.append('a');
            }
            sb.append('b');
        } else {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println((int)'a');
    }
}
