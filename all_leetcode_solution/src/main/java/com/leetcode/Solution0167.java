package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2021/7/11
 * @description : 数组有序，答案唯一
 */
public class Solution0167 {
    public static void main(String[] args) {
        Solution0167 obj = new Solution0167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(obj.twoSum(numbers, target)));

        int[] numbers2 = {2, 7, 11, 15, 19};
        System.out.println(Arrays.toString(obj.twoSum2(numbers2, 18)));
    }

    //双指针
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{-1, -1};
    }


    //二分查找
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int l = i + 1, r = numbers.length - 1;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (numbers[i] + numbers[mid] == target) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[i] + numbers[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return new int[]{-1, -1};
    }
}