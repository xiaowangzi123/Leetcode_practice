package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :仅执行一次字符串交换能否使两个字符串相等
 */
public class Solution1893 {
    public static void main(String[] args) {
        Solution1893 obj = new Solution1893();
        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int left = 2, right = 5;
        System.out.println(obj.isCovered(ranges, left, right));
        System.out.println(obj.isCovered2(ranges, left, right));
        System.out.println(obj.isCovered3(ranges, left, right));
        System.out.println("-----------------------------");

    }


    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean flag = false;
            for (int[] range : ranges) {
                if ((range[0] <= i && range[1] >= i)) {
                    flag = true;
                    continue;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }


    /**
     * 数量50，可以设置初始数组
     */
    public boolean isCovered2(int[][] ranges, int left, int right) {
        boolean[] flags = new boolean[51];
        for (int[] rang : ranges) {
            for (int i = rang[0]; i <= rang[1]; i++) {
                flags[i] = true;
            }
        }
        for (int i = left; i <= right; i++) {
            if (!flags[i]) {
                return false;
            }
        }
        return true;
    }


    public boolean isCovered3(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (x, y) -> x[0] - y[0]);
        for (int[] r : ranges) {
            if (r[0] <= left && left <= r[1]) {
                left = r[1]+1;
            }
        }
        return left > right;
    }

}