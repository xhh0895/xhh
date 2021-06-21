package com.xhh.algorithm;

/**
 * @Description:
 * @Author: xhh
 * @Date: 2021/5/17 17:03
 */
public class LeeCode1523 {

    /**
     * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(solution2(1,7));
    }

    /**
     * 遍历法
     * 超出时间限制
     * @param low
     * @param high
     * @return
     */
    public static int solution1(int low, int high) {
        int total = 0;
        for (int i = low; i <= high; i++) {
            if (isQ(i)) {
                total++;
            }
        }

        return total;
    }

    /**
     * @param low
     * @param high
     * @return
     */
    public static int solution2(int low, int high) {
        if (low == high) {
            if (low % 2 == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        if (isQ(low) || isQ(high)) {
            return (high - low) / 2 + 1;
        } else {
            return (high - low) / 2;
        }
    }

    public static boolean isQ(int num) {
        if (num == 0) return false;
        if (num % 2 == 0) {
            return false;
        }
        return true;
    }
}
