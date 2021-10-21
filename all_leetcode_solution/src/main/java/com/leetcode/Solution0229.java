package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/22
 * @description : 求众数 II
 */
public class Solution0229 {
    public static void main(String[] args) {
        Solution0229 obj = new Solution0229();
        int[] arr = {3, 2, 3};
        System.out.println(obj.majorityElement(arr));
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}