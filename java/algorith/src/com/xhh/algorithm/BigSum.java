package com.xhh.algorithm;

/**
 * @description:
 * @author: xhh
 * @date: 2021/6/9 10:04
 */
public class BigSum {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static String sum(String a, String b) {
        if (a == null || "".equals(a)) {
            return b;
        }
        if (b == null || "".equals(b)) {
            return a;
        }
        // 补全
        if (a.length() > b.length()) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < a.length() - b.length(); i++) {
                sb.append("0");
            }
            b = sb.append(b).toString();
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < b.length() - a.length(); i++) {
                sb.append("0");
            }
            a = sb.append(a).toString();
        }
        StringBuffer res = new StringBuffer();
        boolean tmp = false;// 进位
        for (int i = a.length() - 1; i >= 0; i--) {
            int x = a.charAt(i) - '0';
            int y = b.charAt(i) - '0';
            int sum = (tmp ? 1 : 0)  + x + y;
            if (sum >= 10) {
                tmp = true;
                sum -= 10;
            } else {
                tmp = false;
            }
            res.append(sum);
        }
        if (tmp) {
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(BigSum.sum("12346", "1234"));
    }
}
