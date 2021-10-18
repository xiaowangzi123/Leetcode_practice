package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/18
 * @description : 三维形体的表面积
 */
public class Solution0892 {
    public static void main(String[] args) {
        Solution0892 obj = new Solution0892();
//        int[][] grid = {{2}};
        int[][] grid = {{1, 2}, {3, 4}};
        System.out.println(obj.surfaceArea(grid));
    }

    public int surfaceArea(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int count = grid[i][j];
                if (count > 0) {
                    ans += (count * 4 + 2);
                    if (i > 0 && grid[i - 1][j] > 0) {
                        int a = Math.min(count, grid[i - 1][j]);
                        ans -= a * 2;
                    }
                    if (j > 0 && grid[i][j - 1] > 0) {
                        int b = Math.min(count, grid[i][j - 1]);
                        ans -= b * 2;
                    }
                }
            }
        }

        return ans;
    }
}