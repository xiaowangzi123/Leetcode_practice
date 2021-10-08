package com.leetcode;

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

    }

    /**
     * 排序和双指针
     * 1.首先进行数组排序，时间复杂度O(nlogn)
     * 2.在数组nums中，进行遍历，每遍历一个值利用其下标i，形成一个固定值 nums[i]
     * 3.再使用前指针指向L=i+1处，后指针指向R=nums.length-1处
     * 4.根据 sum =nums[i]+nums[L]+nums[R]的结果，判断sum与目标target的距离，如果更近则更新结果ans
     *   4.1同时判断sum与 target 的大小关系，因为数组有序，
     *   4.2如果 sum > target 则 end--，
     *   4.3如果 sum < target 则 start++，
     *   4.4如果 sum == target 则说明距离为 0 直接返回结果
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
                }else {
                    return ans;
                }
            }
        }
        return ans;
    }
}