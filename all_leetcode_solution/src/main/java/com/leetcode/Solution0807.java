package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2021/12/13
 * @description: 保持城市天际线
 */
public class Solution0807 {
    public static void main(String[] args) {
        Solution0807 obj = new Solution0807();
        System.out.println(obj.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
        System.out.println(obj.maxIncreaseKeepingSkyline2(new int[][]{{2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));

    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length, ans = 0;
        int[] row = new int[n], col = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += (Math.min(row[i], col[j]) - grid[i][j]);
            }
        }
        return ans;
    }

    public int maxIncreaseKeepingSkyline2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] row = new int[m], col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += (Math.min(row[i], col[j]) - grid[i][j]);
            }
        }
        return ans;
    }
}