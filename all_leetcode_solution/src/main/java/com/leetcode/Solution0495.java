package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/15
 * @description :提莫攻击
 */
public class Solution0495 {
    public static void main(String[] args) {
        Solution0495 obj = new Solution0495();
        int[] arr = {1, 4};
        System.out.println(obj.findPoisonedDuration(arr, 2));

    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            if (timeSeries[i + 1] - timeSeries[i] > duration) {
                count += duration;
            } else {
                count += timeSeries[i + 1] - timeSeries[i];
            }
        }

        return count + duration;
    }
}