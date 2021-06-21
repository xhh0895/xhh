package com.xhh.algorithm;

import java.util.Arrays;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为x的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class LeeCode1046 {

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }

        for (int i = stones.length - 1; i >= 0; ) {
            Arrays.sort(stones);
            if (stones[i] == 0) return 0;
            if (stones[i - 1] == 0) {
                return stones[i];
            }
            if (stones[i] == stones[i -1]) {
                stones[i] = stones[i -1] = 0;
            } else {
                stones[i] = stones[i] - stones[i - 1];
                stones[i - 1] = 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] stones = new int[]{2,7,4,1,8,1};
//        System.out.println(lastStoneWeight(stones));

        System.out.println(convertInteger(528611498, -1619967984));
    }

    public static int convertInteger(int A, int B) {
        String strA = Integer.toBinaryString(A);
        String strB = Integer.toBinaryString(B);

        int high = Math.abs(strA.length() - strB.length());
        int low = Math.min(strA.length(), strB.length());

        int count = 0;
        for (int i = 0; i < low; i++) {
            if (strA.charAt(strA.length() - 1 - i) != strB.charAt(strB.length() - 1 - i)) {
                count++;
            }
        }

        if (high > 0&& strA.length() > low) {
            for (int i = 0; i < high; i++) {
                if (strA.charAt(i) != '0') {
                    count++;
                }
            }
        } else if(high > 0&& strB.length() > low) {
            for (int i = 0; i < high; i++) {
                if (strB.charAt(i) != '0') {
                    count++;
                }
            }
        }

        return count;
    }
}
