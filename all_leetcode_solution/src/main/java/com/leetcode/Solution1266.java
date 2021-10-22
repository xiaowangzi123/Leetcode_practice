package com.leetcode;

import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/22
 * @description : 访问所有点的最小时间
 */
public class Solution1266 {
    public static void main(String[] args) {
        Solution1266 obj = new Solution1266();
        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(obj.minTimeToVisitAllPoints(points));
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        for (int i = 1; i < points.length; i++) {
            int a = Math.abs(points[i][0] - points[i - 1][0]);
            int b = Math.abs(points[i][1] - points[i - 1][1]);
            count += Math.max(a, b);
        }

        return count;
    }
}