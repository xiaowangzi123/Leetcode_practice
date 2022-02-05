package com.leetcode.backtrace;


/**
 * @author: wyq
 * @create time: 2022/2/5
 * @description: 黄金矿工
 */
public class Solution1219 {
    public static void main(String[] args) {
        Solution1219 obj = new Solution1219();
        System.out.println(obj.getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
        System.out.println(obj.getMaximumGold(new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}));
    }

    int ans = 0;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    backtrack(i, j, 0, m, n, grid);
                }
            }
        }
        return ans;
    }

    public void backtrack(int i, int j, int gold, int m, int n, int[][] grid) {
        gold += grid[i][j];
        ans = Math.max(ans, gold);
        int temp = grid[i][j];
        grid[i][j] = 0;
        for (int d = 0; d < 4; d++) {
            int x = i + dirs[d][0];
            int y = j + dirs[d][1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0) {
                backtrack(x, y, gold, m, n, grid);
            }
        }
        grid[i][j] = temp;
    }
}