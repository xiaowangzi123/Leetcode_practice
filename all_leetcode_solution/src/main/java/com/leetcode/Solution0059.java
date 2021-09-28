package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/16
 * @description ：螺旋矩阵 II
 */
public class Solution0059 {
    public static void main(String[] args) {
        Solution0059 obj = new Solution0059();
        System.out.println(Arrays.deepToString(obj.generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1, max = n * n;
        //上下左右四个边界
        int up = 0, down = n - 1, left = 0, right = n - 1;
        while (count <= max) {
            //从左到右，循环结束后，上部边界加1
            for (int i = left; i <= right; i++) {
                res[up][i] = count++;
            }
            up++;

            //从上到下，循环结束后，右边界减一
            for (int i = up; i <= down; i++) {
                res[i][right] = count++;
            }
            right--;

            //从右到左，循环结束后，下边界减一
            for (int i = right; i >= left; i--) {
                res[down][i] = count++;
            }
            down--;

            //从下到上，循环结束后，左边界加1
            for (int i = down; i >= up; i--) {
                res[i][left] = count++;
            }
            left++;
        }
        return res;
    }
}