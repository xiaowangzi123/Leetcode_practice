package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/21
 * @description : 二维网格迁移
 */
public class Solution1260 {
    public static void main(String[] args) {
        Solution1260 obj = new Solution1260();
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(obj.shiftGrid(grid, 1));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[index++] = grid[i][j];
            }
        }
        while (k > 0) {
            for (int i = arr.length - 1; i >0; i--) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
            k--;
        }
        index = 0;
        List<Integer> list = new ArrayList<>();
        while (index < 9) {
            list.add(arr[index]);
            if (index % 3 == 2) {
                ans.add(new ArrayList<>(list));
                list.clear();
            }
            index++;
        }
        return ans;
    }
}