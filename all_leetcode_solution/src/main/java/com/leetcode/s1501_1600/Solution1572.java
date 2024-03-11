package com.leetcode.s1501_1600;

/**
 * 矩阵对角线元素的和
 */
public class Solution1572 {
    public static void main(String[] args) {
        Solution1572 obj = new Solution1572();
        int[][] mat = {{1, 2}, {4, 5}};
        System.out.println(mat.length);
        System.out.println(obj.diagonalSum(mat));
    }

    public int diagonalSum(int[][] mat) {
        int row = mat.length;
        int sum = 0;
        //对角线数据相加
        for (int i = 0; i < row; i++) {
            sum += mat[i][i] + mat[i][row - i - 1];
        }

        //去掉中间重复相加的数据
        if (row % 2 == 1) {
            sum -= mat[row / 2][row / 2];
        }
        return sum;

    }
}