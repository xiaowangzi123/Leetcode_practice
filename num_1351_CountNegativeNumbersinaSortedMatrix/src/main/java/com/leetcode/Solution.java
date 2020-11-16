package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/16
 * @description：
 */
public class Solution {
    public static void main(String[] args) {
        int[][] mat = {{1, -2}, {4, 5}, {8, 9}};
        System.out.println("column:" + mat.length);
        System.out.println("row:" + mat[0].length);
        Solution obj = new Solution();
        System.out.println(obj.countNegatives(mat));
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
}