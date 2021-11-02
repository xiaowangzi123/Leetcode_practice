package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/11
 * @description :最长特殊序列 Ⅰ
 */
public class Solution0521 {
    public static void main(String[] args) {
        Solution0521 obj = new Solution0521();
        String a = "aba", b = "cdc";
        System.out.println(obj.findLUSlength(a, b));
    }

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}