package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/16
 * @description :
 */
public class Solution0598 {
    public static void main(String[] args) {
        Solution0598 obj = new Solution0598();
        int m = 3, n = 3;
        int[][] operations = {{2, 2}, {3, 3}};
        System.out.println(obj.maxCount(m, n, operations));
        System.out.println(obj.maxCount2(m, n, operations));
    }

    public int maxCount(int m, int n, int[][] ops) {
        int count = 0;
        int[][] ans = new int[m][n];
        for (int[] arr : ops) {
            for (int i = 0; i < arr[0]; i++) {
                for (int j = 0; j < arr[1]; j++) {
                    ans[i][j]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == ans[0][0]) {
                    count++;
                }
            }
        }
        return count;
    }

    public int maxCount2(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}