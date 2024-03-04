package com.leetcode;

import java.util.Arrays;

/**
 * 矩阵置零
 */
public class Solution0073 {
    public static void main(String[] args) {
        Solution0073 obj = new Solution0073();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        obj.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }


    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m], column = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = column[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}