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
     * 多个中心并行，dfs深度遍历不行，需要改进
     * 先把0周边的填充，然后填充1周边的
     * 值最大不超过m+n-1
     */
    public int[][] highestPeak2(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(ans[i], -1);
        }

        int[][] dic = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < m + n - 1; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (ans[i][j] == k) {
                        for (int d = 0; d <= 3; d++) {
                            int a = i + dic[d][0];
                            int b = j + dic[d][1];
                            if (a >= 0 && a < m && b >= 0 && b < n && ans[a][b] == -1) {
                                ans[a][b] = k + 1;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }


}