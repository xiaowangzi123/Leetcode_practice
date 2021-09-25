package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/25
 * @description：
 */
public class Solution1143 {
    public static void main(String[] args) {
        Solution1143 obj = new Solution1143();
        String s1 = "abcde", s2 = "ace";
        System.out.println(obj.longestCommonSubsequence(s1, s2));
    }

    /**
     * cnt[i][j]表示text1[0:i]和text2[0:j]的最长公共子序列的长度。
     * text1[0:i]表示text1的长度为i的前缀，text2[0:j]表示text2的长度为j的前缀。
     *
     * 当i=0时，任意的j,有cnt[0][j]=0
     * 当j=0时，任意的i,有cnt[i][0]=0
     *
     *
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] count = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char ch1 = text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char ch2 = text2.charAt(j-1);
                if (ch1 == ch2) {
                    count[i][j] = count[i - 1][j - 1] + 1;
                } else {
                    count[i][j] = Math.max(count[i - 1][j], count[i][j - 1]);
                }
            }
        }
        return count[m][n];
    }
}