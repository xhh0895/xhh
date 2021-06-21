package com.xhh.algorithm;

/**
 * 大数乘法
 * @description:
 * @author: xhh
 * @date: 2021/6/15 11:00
 */
public class LeeCode43 {

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        String res = "0";
        int len = num2.length();
        for (int i = 0; i < num2.length(); i++) {
//            num1 * num2[len - i - 1] *  (int)Math.pow(10, i);
            int base = Integer.parseInt(String.valueOf(num2.charAt(len - i - 1)));
            StringBuffer sm = new StringBuffer();
            int w = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int sum = base * Integer.parseInt(String.valueOf(num1.charAt(j))) + w;
                sm.append(sum % 10);
                w = sum / 10;
            }
            if (w != 0) {
                sm.append(w);
            }
            sm = sm.reverse();
            System.out.println(sm.toString());
            for (int k = 0; k < i; k++) {
                sm.append("0");
            }
            res = sum(res, sm.toString());
        }
        return res;
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

    public static void main(String[] args) {
        System.out.println(multiply("123456789", "987654321"));
    }
}
