package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2022/4/22
 * @description: TODO
 * 396. 旋转函数
 */
public class Solution0396 {
    public static void main(String[] args) {
        Solution0396 obj = new Solution0396();
        System.out.println(obj.maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println(obj.maxRotateFunction(new int[]{100}));
    }

    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

}