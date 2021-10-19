package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author :wyq
 * @date ：Created in 2021/10/19
 * @description : 距离顺序排列矩阵单元格
 */
public class Solution1030 {
    public static void main(String[] args) {
        Solution1030 obj = new Solution1030();
        System.out.println(Arrays.deepToString(obj.allCellsDistOrder2(1, 2, 0, 0)));
    }

    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] ret = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ret[i * cols + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                int len1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
                int len2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
//                return (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)) - (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter));
                return len1 - len2;
            }
        });
        return ret;
    }

    public int[][] allCellsDistOrder2(int rows, int cols, int rCenter, int cCenter) {
        int[][] ans = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans[i * cols + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ans, Comparator.comparingInt(a -> (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter))));
        return ans;
    }
}