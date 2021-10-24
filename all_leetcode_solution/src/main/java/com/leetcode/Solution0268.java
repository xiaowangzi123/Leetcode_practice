package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/9
 * @description : 丢失的数字
 */
public class Solution0268 {
    public static void main(String[] args) {
        Solution0268 obj = new Solution0268();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(obj.missingNumber(nums));
        System.out.println(obj.missingNumber2(nums));
        System.out.println(obj.missingNumber3(nums));
        System.out.println(obj.missingNumber4(nums));
        System.out.println("-------------------------");

        //没有缺数字，输出下一位
        System.out.println(obj.missingNumber(new int[]{0, 1, 2, 3}));
        System.out.println(obj.missingNumber2(new int[]{0, 1, 2, 3}));
        System.out.println(obj.missingNumber3(new int[]{0, 1, 2, 3}));
        System.out.println(obj.missingNumber4(new int[]{0, 1, 2, 3}));

        System.out.println("-------------------------");
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(1 ^ 9);
        System.out.println(0 ^ 2);
        System.out.println(0 ^ 0);
        System.out.println(1 ^ 1 ^ 2);

    }

    /**
     * 长度为n,不缺少数字时，和为n(n+1)/2
     * 减去数组长度即为缺失的数字
     */
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = len * (len + 1) / 2;
        for (int i = 0; i < len; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    /**
     * ^相同为0，相异为1
     */
    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        int temp = 0, i = 0;
        for (; i < nums.length; i++) {
            temp ^= i ^ nums[i];
        }
        return temp ^ i;
    }

    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //效率低
    public int missingNumber4(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] != 0) {
            return 0;
        }
        if (nums[n - 1] != n) {
            return n;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return -1;
    }
}