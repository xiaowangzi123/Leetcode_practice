package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2021/12/20
 * @description: 供暖器
 */
public class Solution0475 {
    public static void main(String[] args) {
        Solution0475 obj = new Solution0475();
//        System.out.println(obj.findRadius(new int[]{1, 2, 3}, new int[]{2}));
        System.out.println(obj.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4}));
        System.out.println(obj.findRadius(new int[]{1, 5}, new int[]{2}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < houses.length; i++) {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < heaters.length; j++) {
                ans = Math.min(ans, Math.abs(houses[i] - heaters[j]));
            }
            min = Math.max(min, ans);
        }
        return min;
    }
}