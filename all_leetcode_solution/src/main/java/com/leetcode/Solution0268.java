package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/9
 * @description :
 */
public class Solution0268 {
    public static void main(String[] args) {
        Solution0268 obj = new Solution0268();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(obj.missingNumber(nums));
        System.out.println(obj.missingNumber2(nums));

        System.out.println("-------------------------");
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println(0 ^ 0);
        System.out.println(1 ^ 1 ^ 2);

    }

    //
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = (0 + len) * (len + 1) / 2;
        for (int i = 0; i < len; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public int missingNumber2(int[] nums) {
//        Arrays.sort(nums);
        int tem = 0, i = 0;
        for (; i < nums.length; i++) {
            tem = tem ^ i ^ nums[i];
        }
        return tem ^ i;
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
}