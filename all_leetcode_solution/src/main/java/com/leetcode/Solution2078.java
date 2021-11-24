package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 两栋颜色不同且距离最远的房子
 */
public class Solution2078 {
    public static void main(String[] args) {
        Solution2078 obj = new Solution2078();
        System.out.println(obj.maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1}));
        System.out.println(obj.maxDistance(new int[]{1, 8, 3, 8, 3}));
    }

    public int maxDistance(int[] colors) {
        int max = Integer.MIN_VALUE, n = colors.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j] && max < j - i) {
                    max = j - i;
                }
            }
        }
        return max;
    }
}