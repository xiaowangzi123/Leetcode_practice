package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/14
 * @description :唯一元素的和
 */
public class Solution1748 {
    public static void main(String[] args) {
        Solution1748 obj = new Solution1748();

        int[] nums = {1, 2, 3, 2};
        System.out.println(obj.sumOfUnique(nums));
        System.out.println(obj.sumOfUnique2(nums));
    }


    //出现一次的元素，相加之和
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }
        return sum;
    }

    public int sumOfUnique2(int[] nums) {
        int sum = 0;
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i < 101; i++) {
            if (count[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}