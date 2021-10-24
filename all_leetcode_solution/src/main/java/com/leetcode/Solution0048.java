package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/16
 * @description：
 */
public class Solution0048 {
    public static void main(String[] args) {
        Solution0048 obj = new Solution0048();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(arr.length);
        obj.rotate(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = matrix[n - j - 1][i];
            }
        }

        //二维数组复制
        // 方法一
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }*/

        //方法二
        /*for (int i = 0; i < n; i++) {
            matrix[i] = temp[i].clone();
        }*/

        /**
         * System.arraycopy()方法使用
         * public static native void arraycopy(Object src,  int srcPos, Object dest, int destPos, int length);
         * 从源数组src取元素，范围为下标srcPos到srcPos+length-1，
         * 取出共length个元素，存放到目标数组中，存放位置为下标destPos到destPos+length-1。
         */
       /* for (int i = 0; i < n; i++) {
            System.arraycopy(temp[i], 0, matrix[i], 0, n);
        }*/

        //Arrays.copyOf() 占用空间少
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.copyOf(temp[i], n);
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

}