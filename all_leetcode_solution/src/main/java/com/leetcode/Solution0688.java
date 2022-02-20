package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/2/19
 * @description: 骑士在棋盘上的概率
 */
public class Solution0688 {
    public static void main(String[] args) {
        Solution0688 obj = new Solution0688();
        System.out.println(obj.knightProbability(1, 0, 0, 0));
        System.out.println(obj.knightProbability(3, 2, 0, 0));
    }

    /**
     * 八个方向
     */
    static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    /**
     * step：步数
     * 定义dp[step][i][j]表示骑士从棋盘上的点(i,j) 出发，走了step步时仍然留在棋盘上的概率
     * 当点(i,j)不在棋盘上时，dp[step][i][j]=0
     * 当点(i,j) 在棋盘上且step=0 时，dp[step][i][j]=1
     */
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[0][i], 1);
        }

        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            dp[step][i][j] += dp[step - 1][x][y] / 8;
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }

}