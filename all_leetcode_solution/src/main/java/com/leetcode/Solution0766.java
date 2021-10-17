package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :
 */
public class Solution0766 {
    public static void main(String[] args) {
        Solution0766 obj = new Solution0766();
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(obj.isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}