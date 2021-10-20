package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/20
 * @description : 三维形体投影面积
 */
public class Solution0883 {
    public static void main(String[] args) {
        Solution0883 obj = new Solution0883();
        int[][] grid = {{1, 2}, {3, 4}};
        System.out.println(obj.projectionArea(grid));
    }

    /**
     * 俯视图统计每个点不为零的数量
     * 正视图统计每行最大值
     * 侧面统计每列最大值
     */
    public int projectionArea(int[][] grid) {
        int count = 0, a = 0;
        for (int i = 0; i < grid.length; i++) {
            int b = 0, c = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    a++;
                }
                b = Math.max(b, grid[i][j]);
                c = Math.max(c, grid[j][i]);
            }
            count += b + c;
        }

        return count;
    }
}