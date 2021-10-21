package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/21
 * @description : 缀点成线
 */
public class Solution1232 {
    public static void main(String[] args) {
        Solution1232 obj = new Solution1232();
        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(obj.checkStraightLine(coordinates));
    }

    /**
     * 直线经过点(x1,y1)和点(x2,y2)，且斜率存在
     * 则(x-x1)(y1-y2)=(y-y1)(x1-x2)
     */
    public boolean checkStraightLine(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int a = (arr[i][0] - arr[0][0]) * (arr[0][1] - arr[n - 1][1]);
            int b = (arr[i][1] - arr[0][1]) * (arr[0][0] - arr[n - 1][0]);
            if (a != b) {
                return false;
            }
        }
        return true;
    }
}