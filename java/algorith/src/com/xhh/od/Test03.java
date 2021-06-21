package com.xhh.od;

import java.util.*;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/19 16:26
 */
public class Test03 {

    public static void main(String[] args) {
        // dp问题
        Scanner in = new Scanner(System.in);
        int[] nums = new int[10];
        int total = 0;
        for (int i = 0; i < 10; i++) {
            nums[i] = in.nextInt();
            total += nums[i];
        }
        float avg = (float) total / 10;
        float[][] dicSort = new float[10][3];
        for (int i = 0; i < 10; i++) {
            dicSort[i][0] = Math.abs(nums[i] - avg);
            dicSort[i][1] = i;
            dicSort[i][2] = nums[i];
        }
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (dicSort[i][0] > dicSort[j][0]) {
                    float[] t = dicSort[i];
                    dicSort[i] = dicSort[j];
                    dicSort[j] = t;
                }
            }
        }
        System.out.println(dicSort);
        int[] tm1 = new int[5];
        int[] tm2 = new int[5];
        for (int i = 0; i < 5; i++) {
            tm1[i] = (int) dicSort[i][2];
            tm2[i] = (int) dicSort[5 + i][2];
        }

        Arrays.sort(tm1);
        Arrays.sort(tm2);

        int cnt1 = 0, cnt2 = 0;
        cnt1 += tm1[0] + tm2[4];
        cnt2 += tm1[1] + tm2[3];
        cnt1 += tm1[2] + tm2[2];
        cnt1 += tm1[3] + tm2[1];

        if (cnt1 > cnt2) {
            cnt1 += Math.min(tm1[4], tm2[0]);
            cnt2 += Math.max(tm1[4], tm2[0]);
        } else {
            cnt1 += Math.max(tm1[4], tm2[0]);
            cnt2 += Math.min(tm1[4], tm2[0]);
        }

        System.out.println(Math.abs(cnt1 - cnt2));
    }


}
