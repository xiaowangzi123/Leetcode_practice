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