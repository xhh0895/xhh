package com.xhh.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/21 18:03
 */
public class LeeCode150 {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if ("+".equals(t)) {
                int s1 = stack.pop(), s2 = stack.pop();
                res = s1 + s2;
                stack.push(res);
            } else if ("-".equals(t)) {
                int s1 = stack.pop(), s2 = stack.pop();
                res = s2 - s1;
                stack.push(res);
            } else if ("*".equals(t)) {
                int s1 = stack.pop(), s2 = stack.pop();
                res = s1 * s2;
                stack.push(res);
            } else if ("/".equals(t)) {
                int s1 = stack.pop(), s2 = stack.pop();
                res = s2 / s1;
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }
}
