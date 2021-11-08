package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/8
 * @description : 二进制加法
 */
public class OfferTwo0002 {
    public static void main(String[] args) {
        OfferTwo0002 obj = new OfferTwo0002();
        System.out.println(obj.addBinary("111", "100"));
    }

    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int m = i >= 0 ? a.charAt(i) - '0' : 0;
            int n = j >= 0 ? b.charAt(j) - '0' : 0;
            res.append((m + n + ca) % 2);
            ca = (m + n + ca) / 2;
        }
        if (ca == 1) {
            res.append(ca);
        }
        return res.reverse().toString();
    }
}