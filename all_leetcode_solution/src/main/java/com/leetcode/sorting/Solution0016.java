package com.leetcode.sorting;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/10/08
 * @description ：
 */
public class Solution0016 {
    public static void main(String[] args) {
        Solution0016 obj = new Solution0016();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(obj.threeSumClosest(arr, 0));
        System.out.println(obj.threeSumClosest2(arr, 0));

        int[] arr2 = {-1, 2, 1, -4};
        System.out.println(obj.threeSumClosest(arr2, 1));
        System.out.println(obj.threeSumClosest2(arr2, 1));

    }

    /**
     * 排序和双指针
     * 1.首先进行数组排序，时间复杂度O(nlogn)
     * 2.在数组nums中，进行遍历，每遍历一个值利用其下标i，形成一个固定值 nums[i]
     * 3.再使用前指针指向L=i+1处，后指针指向R=nums.length-1处
     * 4.根据 sum =nums[i]+nums[L]+nums[R]的结果，判断sum与目标target的距离，如果更近则更新结果ans
     * 4.1同时判断sum与 target 的大小关系，因为数组有序，
     * 4.2如果 sum > target 则 end--，
     * 4.3如果 sum < target 则 start++，
     * 4.4如果 sum == target 则说明距离为 0 直接返回结果
     */
    public int threeSumClosest(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length, ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; ++i) {
            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(sum - target) < Math.abs(ans - target)) {
                    ans = sum;
                }
                if (sum > target) {
                    R--;
                } else if (sum < target) {
                    L++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

    public int threeSumClosest2(int[] nums, int target) {
        int n = nums.length, ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            //如果两数相等跳过当前，继续下一循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                //和与target相等，直接返回
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(ans - target) > Math.abs(sum - target)) {
                    ans = sum;
                }
                //sum小于target，右边界向左移动一位
                if (sum > target) {
                    right--;
                    //相邻两个值相等，跳过相同值
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}