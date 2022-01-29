package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: wyq
 * @create time: 2022/1/29
 * @description: 地图中的最高点
 */
public class Solution1765 {
    public static void main(String[] args) {
        Solution1765 obj = new Solution1765();
        System.out.println(Arrays.deepToString(obj.highestPeak(new int[][]{{0, 1}, {0, 0}})));

    }

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length,n=isWater[0].length;
        int[][] ans = new int[m][n];

        return ans;
    }

}