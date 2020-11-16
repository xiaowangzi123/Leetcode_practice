package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/14
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {4, 5}};
        System.out.println(mat.length);
        Solution obj = new Solution();
        System.out.println(obj.diagonalSum(mat));
    }

    public int diagonalSum(int[][] mat) {
        int row = mat.length;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += mat[i][i] + mat[i][row - i - 1];
        }

        if (row % 2 == 1) {
            sum -= mat[row / 2][row / 2];
        }
        return sum;

    }
}