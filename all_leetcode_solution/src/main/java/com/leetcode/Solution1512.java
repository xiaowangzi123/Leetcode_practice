package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/13
 * @description :好数对的数目
 */
public class Solution1512 {
    public static void main(String[] args) {
        Solution1512 obj = new Solution1512();
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(obj.numIdenticalPairs(nums));
        System.out.println(obj.numIdenticalPairs2(nums));
    }


    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 统计每个元素出现的次数k
     * 此元素贡献k(k-1)/2对数量
     */

    public int numIdenticalPairs2(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int temp = entry.getValue();
            count += (temp - 1) * temp / 2;
        }

        return count;
    }
}