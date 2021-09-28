package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/9/28
 * @description : 螺旋矩阵
 */
public class Solution0054 {
    public static void main(String[] args) {
        Solution0054 obj = new Solution0054();
        int[][] arr = {{1, 2, 3, 4,}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(obj.spiralOrder(arr));
        System.out.println(obj.spiralOrder(arr2));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, count = 0, max = m * n;
        List<Integer> ans = new ArrayList<>();
        //上下左右四个边界
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (count <= max && up <= down && left <= right) {
            //从左到右，循环结束后，上部边界加1
            for (int i = left; i <= right && count < max; i++) {
                ans.add(matrix[up][i]);
                count++;
            }
            up++;

            //从上到下，循环结束后，右边界减一
            for (int i = up; i <= down && count < max; i++) {
                ans.add(matrix[i][right]);
                count++;
            }
            right--;

            //从右到左，循环结束后，下边界减一
            for (int i = right; i >= left && count < max; i--) {
                ans.add(matrix[down][i]);
                count++;
            }
            down--;

            //从下到上，循环结束后，左边界加1
            for (int i = down; i >= up && count < max; i--) {
                ans.add(matrix[i][left]);
                count++;
            }
            left++;
        }
        return ans;
    }
}