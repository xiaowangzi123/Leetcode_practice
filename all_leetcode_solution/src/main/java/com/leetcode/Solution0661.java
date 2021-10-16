package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :图片平滑器
 */
public class Solution0661 {
    public static void main(String[] args) {
        Solution0661 obj = new Solution0661();
        int[][] arr = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(obj.imageSmoother(arr)));
    }

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int p = i - 1; p <= i + 1; p++) {
                    for (int q = j - 1; q <= j + 1; ++q) {
                        if (0 <= p && p < m && 0 <= q && q < n) {
                            ans[i][j] += img[p][q];
                            count++;
                        }
                    }
                }
                ans[i][j] /= count;
            }
        }
        return ans;
    }

}