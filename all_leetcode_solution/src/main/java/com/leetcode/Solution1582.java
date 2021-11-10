package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/10
 * @description : 二进制矩阵中的特殊位置
 */
public class Solution1582 {
    public static void main(String[] args) {
        Solution1582 obj = new Solution1582();
        int[][] mat = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(obj.numSpecial(mat));
    }

    /**
     * 计算每一行的和，形成数组a[m],a[i]
     */
    public int numSpecial(int[][] mat) {
        int count = 0, m = mat.length, n = mat[0].length;
        int[] a = new int[m], b = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i] += mat[i][j];
                b[j] += mat[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && a[i] + b[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}