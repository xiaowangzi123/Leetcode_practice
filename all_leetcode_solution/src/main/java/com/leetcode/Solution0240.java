package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/17
 * @description：
 */
public class Solution0240 {
    public static void main(String[] args) {
        Solution0240 ojb = new Solution0240();
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        System.out.println(ojb.searchMatrix(matrix, 19));
        System.out.println(ojb.searchMatrix2(matrix, 19));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int column = 0, row = matrix.length - 1;
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] > target) {
                row--;
            } else if (matrix[row][column] < target) {
                column++;
            } else {
                return true;
            }
        }
        return false;
    }


}