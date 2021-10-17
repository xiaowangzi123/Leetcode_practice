package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/17
 * @description :
 */
public class Solution0867 {
    public static void main(String[] args) {
        Solution0867 obj = new Solution0867();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(obj.transpose(matrix)));
    }

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0; j<m;j++){
                ans[i][j]=matrix[j][i];
            }
        }
        return ans;
    }
}