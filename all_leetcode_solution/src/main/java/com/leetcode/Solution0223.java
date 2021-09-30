package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/9/30
 * @description :
 */
public class Solution0223 {
    public static void main(String[] args) {
        Solution0223 obj = new Solution0223();

        System.out.println(obj.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a1 = (ax2 - ax1) * (ay2 - ay1), a2 = (bx2 - bx1) * (by2 - by1);
        int a = Math.max(ax1, bx1);
        int b = Math.min(ax2, bx2);
        int c = Math.max(ay1, by1);
        int d = Math.min(ay2, by2);
        if (a >= b || c >= d) {
            return a1 + a2;
        }
        return a1 + a2 - (b - a) * (d - c);
    }
}