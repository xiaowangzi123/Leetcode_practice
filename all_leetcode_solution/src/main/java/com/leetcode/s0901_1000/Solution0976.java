package com.leetcode.s0901_1000;

import java.util.Arrays;

/**
 * 三角形的最大周长
 */
public class Solution0976 {
    public static void main(String[] args) {
        Solution0976 obj = new Solution0976();
        int[] arr = {3, 2, 3, 4};
        System.out.println(obj.largestPerimeter(arr));
    }

    /**
     * 三角形成立条件a+b>c,a+c>b,b+c>a或者a+b>c,|a-b|<c
     * 对数组排序
     * 数组排序后，a<=b<=c 从右向左遍历,则a+c>b和b+c>a一定成立，如果有c<a+b,则是三角形
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    //超时
    public int largestPerimeter22(int[] nums) {
        int max = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (isTriangle(nums[i], nums[j], nums[k])) {
                        max = Math.max(max, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return max;
    }

    //判断三条边能否组成三角形
    public boolean isTriangle(int a, int b, int c) {
        if (a + b > c && Math.abs(a - b) < c) {
            return true;
        }
        return false;
    }
}