package com.leetcode;

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

    //八个方向
    static int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

    /**
     * step：步数
     */
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1;
                    } else {
                        for (int[] dir : dirs) {
                            int ni = i + dir[0], nj = j + dir[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                dp[step][i][j] += dp[step - 1][ni][nj] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }

}