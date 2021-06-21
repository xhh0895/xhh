package com.xhh.algorithm;

import java.util.*;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/8 17:50
 */
public class LeeCode997 {

    public static void main(String[] args) {
        /*
        4
            [[1,3],[1,4],[2,3],[2,4],[4,3]]
         */
        int[][] trust = new int[][]{{1, 3}, {1,4}, {2,3}, {2,4}, {4,3}};
        System.out.println(findJudge(4, trust));
    }

    public static int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;

        Set<String> trustSet = new HashSet<>();
        Map<String, Integer> trst = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
            String key1 = String.valueOf(trust[i][0]);
            trustSet.add(key1);


            String key = String.valueOf(trust[i][1]);
            if (trst.containsKey(key)) {
                trst.put(key, trst.get(key) + 1);
            } else {
                trst.put(key, 1);
            }
        }

        if (trustSet.size() < n - 1) {
            return -1;
        }

        for (Map.Entry<String, Integer> entry : trst.entrySet()) {
            if (entry.getValue() == n -1 && !trustSet.contains(entry.getKey())) {
                return Integer.parseInt(entry.getKey());
            }
        }

        return -1;
    }
}
