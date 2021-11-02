package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/16
 * @description : 统计有序矩阵中的负数
 */
public class Solution1351 {
    public static void main(String[] args) {
        Solution1351 obj = new Solution1351();
        int[][] mat = {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
        System.out.println(obj.countNegatives(mat));
        System.out.println(obj.countNegatives2(mat));

        System.out.println("--------------------------");
    }

    public int countNegatives(int[][] grid) {
        int column = grid.length;
        int rom = grid[0].length;
        int res = 0;
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < rom; j++) {
                if (grid[i][j] < 0) {
                    res++;
                }
            }
        }
        return res;
    }


    //优化，数组非递增排序，找到第一个小于0，后续都小于0
    public int countNegatives2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) {
                    res += (n - j);
                    break;
                }
            }
        }
        return res;
    }
}