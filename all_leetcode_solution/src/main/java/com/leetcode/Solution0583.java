package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/25
 * @description：
 */
public class Solution0583 {
    public static void main(String[] args) {
        Solution0583 obj = new Solution0583();
        String s1 = "sea", s2 = "eat";
        System.out.println(obj.minDistance(s1, s2));

    }


    /**
     * {@link Solution1143}
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] count = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char ch1 = word1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char ch2 = word2.charAt(j-1);
                if (ch1 == ch2) {
                    count[i][j] = count[i - 1][j - 1] + 1;
                } else {
                    count[i][j] = Math.max(count[i - 1][j], count[i][j - 1]);
                }
            }
        }
        return m+n-count[m][n]*2;
    }
}