package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/19
 * @description : 判断矩阵经轮转后是否一致
 */
public class Solution1886 {
    public static void main(String[] args) {
        Solution1886 obj = new Solution1886();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(obj.findRotation(mat, target));
    }

    /**
     * 矩阵不旋转就相等，直接返回true
     *
     */
    public boolean findRotation(int[][] mat, int[][] target) {
        if (Arrays.deepEquals(mat,target)){
            return true;
        }
        int[][] ans;
        for (int k = 0; k < 3; k++) {
            ans = turnMatrix(mat);
            if (Arrays.deepEquals(ans, target)) {
                return true;
            }
            mat = ans;
        }
        return false;
    }

    public int[][] turnMatrix(int[][] mat) {
        int n = mat.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = mat[n - j - 1][i];
            }
        }
        return ans;
    }
}