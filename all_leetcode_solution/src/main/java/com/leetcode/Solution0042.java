package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/3
 * @description : 接雨水
 * {@link Solution0407}
 * todo
 */
public class Solution0042 {
    public static void main(String[] args) {
        Solution0042 obj = new Solution0042();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(obj.trap(height));
    }

    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int lmax = 0, rmax = 0;
            for (int j = i; j >= 0; j--) {
                lmax = Math.max(lmax, height[j]);
            }
            for (int j = i; j < size; j++) {
                rmax = Math.max(rmax, height[j]);
            }
            ans += Math.min(lmax, rmax) - height[i];
        }
        return ans;
    }

    public int trap2(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (height[i] < height[j]) {
                ans += leftMax - height[i];
                i++;
            } else {
                ans += rightMax - height[j];
                j--;
            }
        }
        return ans;
    }

}