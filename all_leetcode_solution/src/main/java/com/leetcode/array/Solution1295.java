package com.leetcode.array;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description :统计位数为偶数的数字
 */
public class Solution1295 {

    public static void main(String[] args) {
        Solution1295 obj = new Solution1295();
        int[] arr = {12, 345, 2, 6, 7896};
        System.out.println(obj.findNumbers(arr));
        System.out.println(obj.findNumbers2(arr));
    }


    public int findNumbers(int[] nums) {
        int count = 0;
        int[] str = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]).length();
            if (str[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int findNumbers2(int[] nums) {
        int count = 0;

        for (int num : nums) {
            if (10 <= num && num < 100) {
                count++;
            } else if (1000 <= num && num < 10000) {
                count++;
            } else if (num == 100000) {
                count++;
            }
        }
        return count;
    }


}