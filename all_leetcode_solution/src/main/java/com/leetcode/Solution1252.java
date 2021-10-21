package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/21
 * @description : 奇数值单元格的数目
 */
public class Solution1252 {
    public static void main(String[] args) {
        Solution1252 obj = new Solution1252();
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(obj.oddCells(2, 3, indices));
        System.out.println(obj.oddCells2(2, 3, indices));
        System.out.println(obj.oddCells3(2, 3, indices));
    }

    public int oddCells(int m, int n, int[][] indices) {
        int count = 0;
        int[][] arr = new int[m][n];
        for (int[] ind : indices) {
            int a = ind[0];
            int b = ind[1];
            for (int i = 0; i < n; i++) {
                arr[a][i]++;
            }
            for (int i = 0; i < m; i++) {
                arr[i][b]++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int oddCells2(int m, int n, int[][] indices) {
        int count = 0;
        int[][] arr = new int[m][n];
        for (int[] ind : indices) {
            int a = ind[0];
            int b = ind[1];
            for (int i = 0; i < n; i++) {
                arr[a][i]^=1;
            }
            for (int i = 0; i < m; i++) {
                arr[i][b]^=1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j]  == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public int oddCells3(int m, int n, int[][] indices) {
        int count = 0;
        int[] rows = new int[m], clos=new int[n];
        for (int[] ind : indices) {
            int a = ind[0];
            int b = ind[1];
            rows[a]++;
            clos[b]++;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i]+clos[j])%2==1){
                    count++;
                }
            }
        }
        return count;
    }
}