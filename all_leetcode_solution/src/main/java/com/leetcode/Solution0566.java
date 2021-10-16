package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/16
 * @description :重塑矩阵
 */
public class Solution0566 {
    public static void main(String[] args) {
        Solution0566 obj = new Solution0566();
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1, c = 4;
        System.out.println(Arrays.deepToString(obj.matrixReshape(mat, r, c)));
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if (r * c != n * m) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = mat[i / m][i % m];
        }
        return res;
    }
}