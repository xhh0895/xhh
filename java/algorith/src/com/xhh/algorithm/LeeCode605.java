package com.xhh.algorithm;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/8 17:07
 */
public class LeeCode605 {

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,0,0,1,0,0};

        System.out.println(LeeCode605.canPlaceFlowers(flowerbed, 2));
    }
    /**
     *
     * @param flowerbed [0,0,0,0,0,1]
     *                  [1,0,0,0,0,1]
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0;) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i+1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }
}
