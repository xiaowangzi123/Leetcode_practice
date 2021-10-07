package com.leetcode;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/14
 * @description：
 */
public class Solution0169 {
    public static void main(String[] args) {
        Solution0169 obj = new Solution0169();
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int[] arr2 = {3, 3, 4};
        System.out.println(obj.majorityElement(arr));
        System.out.println(obj.majorityElement2(arr));
        System.out.println(obj.majorityElement3(arr));


        System.out.println(obj.majorityElement(arr2));
        System.out.println(obj.majorityElement2(arr2));
        System.out.println(obj.majorityElement3(arr2));

    }

    public int majorityElement(int[] nums) {
        int res = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (max < entry.getValue()) {
                max = Math.max(max, entry.getValue());
                res = entry.getKey();
            }
        }

        return res;
    }

    public int majorityElement2(int[] nums) {
        int res = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public int majorityElement3(int[] nums) {
        int res = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count = 1;
            } else {
                if (res == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return res;
    }

    public int majorityElement4(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        return nums[nums.length / 2];
    }


    //方法二改进，找出某个数出现次数超过一半
    public int majorityElement25(int[] nums) {
        int res = 0, max = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}