package com.leetcode;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/29
 * @description: 地图中的最高点
 */
public class Solution1765 {
    public static void main(String[] args) {
        Solution1765 obj = new Solution1765();
        System.out.println(Arrays.deepToString(obj.highestPeak(new int[][]{{0, 1}, {0, 0}})));
        System.out.println(Arrays.deepToString(obj.highestPeak2(new int[][]{{0, 1}, {0, 0}})));

    }

    /**
     * 首先水域地方值先设置为0
     * 然后与0相邻近的位置设置为1
     */
    public int[][] highestPeak(int[][] isWater) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        // -1 表示该格子尚未被访问过
        for (int i = 0; i < m; ++i) {
            Arrays.fill(ans[i], -1);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                    // 将所有水域入队
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int x = p[0] + dir[0], y = p[1] + dir[1];
                if (0 <= x && x < m && 0 <= y && y < n && ans[x][y] == -1) {
                    ans[x][y] = ans[p[0]][p[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return ans;
    }


    /**
     * 多个中心并行，此方法不行，需要改进
     */
    public int[][] highestPeak2(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(ans[i], 10000);
        }

        int[][] dic = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 0) {
                    bfs(ans, dic, i, j, m, n);
                }
            }
        }
        return ans;
    }

    public void bfs(int[][] ans, int[][] dic, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        for (int k = 0; k <= 3; k++) {
            int a = i + dic[k][0];
            int b = j + dic[k][1];
            if (a >= 0 && a < m && b >= 0 && b < n && ans[a][b] == 10000) {
                ans[a][b] = Math.min(ans[a][b], ans[i][j] + 1);
            }
        }

    }

}