package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 将一维数组转变成二维数组
 */
public class Solution2022 {
    public static void main(String[] args) {
        Solution2022 obj = new Solution2022();
        System.out.println(Arrays.deepToString(obj.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2)));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int l = original.length;
        if (l != m * n) {
            return new int[][]{};
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[n * i + j];
            }
        }
        return ans;
    }
}