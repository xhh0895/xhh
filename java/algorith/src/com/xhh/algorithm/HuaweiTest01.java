package com.xhh.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/16 16:38
 */
public class HuaweiTest01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            System.out.println(sol(n));
        }
    }

    public static int sol(int n) {
        if (n < 3) {
            return n;
        }
        int total = n;
        int change = n / 3;
        int free =  n % 3;
        while (free + change >= 3) {
            total += change;
            int t = free + change;
            change = t / 3;
            free = t % 3;
        }
        if (change > 0) {
            total += change;
        }
        if (change + free == 2) {
            total += 1;
        }

        return total - n;
    }
}
