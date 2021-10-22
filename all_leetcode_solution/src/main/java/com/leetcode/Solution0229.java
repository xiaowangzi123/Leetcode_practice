package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/22
 * @description : 求众数 II
 */
public class Solution0229 {
    public static void main(String[] args) {
        Solution0229 obj = new Solution0229();
//        int[] arr = {3, 2, 3};
        int[] arr = {1, 2};
        System.out.println(obj.majorityElement(arr));
        System.out.println(obj.majorityElement2(arr));
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


    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length, count = 0, temp = nums[0];
        for (int num : nums) {
            if (temp == num) {
                count++;
            } else {
                temp = num;
                count = 1;
            }
            if (count > n / 3 && !ans.contains(num)) {
                ans.add(num);
            }
        }
        return ans;
    }

}