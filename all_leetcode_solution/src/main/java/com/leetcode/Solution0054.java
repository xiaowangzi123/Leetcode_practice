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
        System.out.println(obj.spiralOrder2(arr));
        System.out.println(obj.spiralOrder3(arr));

        System.out.println(obj.spiralOrder(arr2));
        System.out.println(obj.spiralOrder2(arr2));
        System.out.println(obj.spiralOrder3(arr2));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, count = 0, max = m * n;
        List<Integer> ans = new ArrayList<>();
        //上下左右四个边界
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (count < max) {
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

    public List<Integer> spiralOrder2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, max = m * n;
        List<Integer> ans = new ArrayList<>();
        //上下左右四个边界
        int up = 0, down = m - 1, left = 0, right = n - 1;
        while (max > 0) {
            //从左到右，循环结束后，上部边界加1
            for (int i = left; i <= right && max > 0; i++) {
                ans.add(matrix[up][i]);
                max--;
            }
            up++;

            //从上到下，循环结束后，右边界减一
            for (int i = up; i <= down && max > 0; i++) {
                ans.add(matrix[i][right]);
                max--;
            }
            right--;

            //从右到左，循环结束后，下边界减一
            for (int i = right; i >= left && max > 0; i--) {
                ans.add(matrix[down][i]);
                max--;
            }
            down--;

            //从下到上，循环结束后，左边界加1
            for (int i = down; i >= up && max > 0; i--) {
                ans.add(matrix[i][left]);
                max--;
            }
            left++;
        }
        return ans;
    }


    public List<Integer> spiralOrder3(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                order.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                order.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    order.add(matrix[bottom][i]);
                }
                for (int i = bottom; i > top; i--) {
                    order.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}