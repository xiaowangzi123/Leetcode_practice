package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :
 */
public class Solution0594 {
    public static void main(String[] args) {
        Solution0594 obj = new Solution0594();
        int[] arr = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(obj.findLHS(arr));
        System.out.println(obj.findLHS2(arr));
        System.out.println(obj.findLHS3(arr));
    }

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        /*for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //如果map的key集中包含当前值+1,符合条件
            if (map.containsKey(entry.getKey() + 1)) {
                //将当前key值对应的value以及key+1对应的value与ans比较，大的保留
                ans = Math.max(ans, entry.getValue() + map.get(entry.getKey() + 1));
            }
        }*/
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                ans = Math.max(ans, map.get(key) + map.get(key + 1));
            }
        }

        return ans;
    }


    //{1, 2, 2, 2, 3, 3, 5, 7}
    public int findLHS2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, index = 0;
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] - nums[index] > 1) {
                index++;
            }
            if (nums[i] - nums[index] == 1) {
                ans = Math.max(ans, i - index + 1);
            }
        }
        return ans;
    }

    //超时
    public int findLHS3(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    temp++;
                } else if (nums[j] + 1 == nums[i]) {
                    temp++;
                    flag = true;
                }
            }
            if (flag) {
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }
}