package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/22
 * @description：
 */
public class Solution0005 {
    public static void main(String[] args) {
        Solution0005 obj = new Solution0005();
        String s = "abcbacaed";
        System.out.println(obj.longestPalindrome(s));
        System.out.println(obj.longestPalindrome2(s));
    }


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        //回文子串的初始和结束索引
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //奇数长度的子串
            int odd = palindromeLength(s, i, i);
            //偶数长度的子串
            int even = palindromeLength(s, i, i + 1);
            int len = Math.max(odd, even);
            //计算start和end值
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);
    }

    //回文子串的个数或奇或偶，计算以某一个或两个元素为中心的回文子串的长度
    public int palindromeLength(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]); //j - i 代表长度减去 1
                if (dp[i][j] &&  j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}