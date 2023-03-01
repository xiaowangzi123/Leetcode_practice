package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description ： 编辑距离
 */
public class Solution0072 {
    public static void main(String[] args) {
        Solution0072 obj = new Solution0072();
        System.out.println(obj.minDistance("a", "ab"));
        System.out.println(obj.minDistance("a", "b"));
        System.out.println(obj.minDistance("中文有很多人用", "中国有很多人"));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }

    // 求三个数的最小值的实用函数
    public static int minimum(int a, int b, int c) {
        return Integer.min(a, Integer.min(b, c));
    }

    // 查找字符串 `X` 和 `Y` 之间的 Levenshtein 距离的函数。
    // `m` 和 `n` 分别是 `X` 和 `Y` 中的字符总数
    public static int dist(String X, int m, String Y, int n) {
        // 基本情况：空字符串(情况 1)
        if (m == 0) {
            return n;
        }

        if (n == 0) {
            return m;
        }

        // 如果字符串的最后一个字符匹配(案例 2)
        int cost = (X.charAt(m - 1) == Y.charAt(n - 1)) ? 0 : 1;

        return minimum(dist(X, m - 1, Y, n) + 1,    // 删除(案例 3a))
                dist(X, m, Y, n - 1) + 1,           // 插入(案例 3b))
                dist(X, m - 1, Y, n - 1) + cost);   // 替换(案例 2 和 3c)
    }


}





