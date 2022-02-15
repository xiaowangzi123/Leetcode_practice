package com.leetcode;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2022/2/15
 * @description : 矩阵中的幸运数
 */
public class Solution1380 {
    public static void main(String[] args) {
        Solution1380 obj = new Solution1380();
//        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        int[][] matrix = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        System.out.println(obj.luckyNumbers(matrix));
    }

    /**
     * 在同一行的所有元素中最小
     * 在同一列的所有元素中最
     * 1.rows[i]第i行最小的元素
     * 2.cols[j]第j列最大的元素
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m], cols = new int[n];
        Arrays.fill(rows, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = Math.min(rows[i], matrix[i][j]);
                cols[j] = Math.max(cols[j], matrix[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == matrix[i][j] && cols[j] == matrix[i][j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }
        return ans;
    }
}