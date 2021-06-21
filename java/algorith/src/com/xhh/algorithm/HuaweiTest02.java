package com.xhh.algorithm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/16 17:00
 */
public class HuaweiTest02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (!list.contains(num)) {
                    list.add(num);
                }
            }
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

}
