package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/13
 * @description : 找到最高海拔
 */
public class Solution1732 {
    public static void main(String[] args) {
        Solution1732 obj = new Solution1732();
        int[] arr = {-5, 1, 5, 0, -7};
        System.out.println(obj.largestAltitude(arr));
    }

    public int largestAltitude(int[] gain) {
        int high = 0, start = 0;
        for (int i = 0; i < gain.length; i++) {
            high = Math.max(high, gain[i] - start);
            start = gain[i];
        }
        return high;
    }
}