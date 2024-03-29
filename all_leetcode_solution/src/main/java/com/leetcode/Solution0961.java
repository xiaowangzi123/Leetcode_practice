package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description : 重复 N 次的元素
 */
public class Solution0961 {
    public static void main(String[] args) {
        Solution0961 obj = new Solution0961();
//        int[] arr = {5, 1, 5, 2, 5, 3, 5, 4};
        int[] arr = {3, 3, 5, 9};
        System.out.println(obj.repeatedNTimes(arr));
        System.out.println(obj.repeatedNTimes2(arr));
        System.out.println(obj.repeatedNTimes3(arr));

    }

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int repeatedNTimes2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 数组长度至少为4
     * {3,3,5,9}，直接返回nums[nums.length/2]，错误
     * 判断前两个元素是否相同
     * 2n个元素，n个重复，如果长度为4，排序后，重复元素排钱两位或后两位
     */
    public int repeatedNTimes3(int[] nums) {
        Arrays.sort(nums);
        return nums[0] == nums[1] ? nums[0] : nums[nums.length / 2];
    }


}