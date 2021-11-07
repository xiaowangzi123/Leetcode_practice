package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/7
 * @description : 字符串转化后的各位数字之和
 */
public class Solution1945 {
    public static void main(String[] args) {
        Solution1945 obj = new Solution1945();
        System.out.println(obj.getLucky("zbax", 2));
        System.out.println(obj.getNumString("zbax"));
        System.out.println(obj.getSumString("262124"));
    }

    public int getLucky(String s, int k) {
        String s1 = getNumString(s);
        while (k > 0 && s1.length() > 0) {
            s1 = getSumString(s1);
            k--;
        }
        return Integer.parseInt(s1);
    }

    public String getNumString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        return sb.toString();
    }

    public String getSumString(String s) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans += (c - '0');
        }
        return String.valueOf(ans);
    }

}