package com.xhh.algorithm;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/15 17:19
 */
public class LeeCode1450 {


    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }

}
