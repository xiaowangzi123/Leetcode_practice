package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/10/18
 * @description : 按奇偶排序数组
 */
public class Solution0905 {
    public static void main(String[] args) {
        Solution0905 obj = new Solution0905();
//        int[] arr = {3, 1, 2, 4};
        int[] arr = {0, 1};
        System.out.println(Arrays.toString(obj.sortnumsrrayByParity(arr)));
        System.out.println(Arrays.toString(obj.sortnumsrrayByParity2(arr)));
    }

    public int[] sortnumsrrayByParity(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 == 0) {
                start++;
            }
            while (start < end && nums[end] % 2 != 0) {
                end--;
            }
            if (nums[start] % 2 != 0 && nums[end] % 2 == 0) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        return nums;
    }

    //对上面的优化
    public int[] sortnumsrrayByParity2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 > nums[j] % 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }

            if (nums[i] % 2 == 0) {
                i++;
            }
            if (nums[j] % 2 == 1) {
                j--;
            }
        }

        return nums;
    }
}