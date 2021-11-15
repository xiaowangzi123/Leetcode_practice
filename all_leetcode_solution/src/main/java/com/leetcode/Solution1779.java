package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/15
 * @description : 找到最近的有相同 X 或 Y 坐标的点
 */
public class Solution1779 {
    public static void main(String[] args) {
        Solution1779 obj = new Solution1779();
        int[][] points = {{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        System.out.println(obj.nearestValidPoint(3, 4, points));
        int[][] points2 = {{3, 4}};
        System.out.println(obj.nearestValidPoint(3, 4, points2));

    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x && Math.abs(y - points[i][1]) < min) {
                min = Math.abs(y - points[i][1]);
                index = i;
            }
            if (y == points[i][1] && Math.abs(x - points[i][0]) < min) {
                min = Math.abs(x - points[i][0]);
                index = i;
            }
        }
        return index;
    }
}