package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/11
 * @description：
 */
public class Solution {

    public static void main(String[] args) {
        Solution obj = new Solution();
        String a = "aba", b = "cdc";
        System.out.println(obj.findLUSlength(a, b));
    }

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}