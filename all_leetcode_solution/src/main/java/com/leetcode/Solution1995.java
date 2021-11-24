package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 统计特殊四元组
 */
public class Solution1995 {
    public static void main(String[] args) {
        Solution1995 obj = new Solution1995();
        System.out.println(obj.countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println(obj.countQuadruplets2(new int[]{1, 2, 3, 6}));
        System.out.println(obj.countQuadruplets(new int[]{3, 3, 6, 4, 5}));
        System.out.println(obj.countQuadruplets2(new int[]{3, 3, 6, 4, 5}));
        System.out.println(obj.countQuadruplets(new int[]{1, 1, 1, 3, 5}));
        System.out.println(obj.countQuadruplets2(new int[]{1, 1, 1, 3, 5}));
    }

    public int countQuadruplets(int[] nums) {
        int n = nums.length, count = 0;
        for (int a = 0; a < n; a++) {
            for (int b = a + 1; b < n; b++) {
                for (int c = b + 1; c < n; c++) {
                    for (int d = c + 1; d < n; d++) {
                        if (nums[a] + nums[b] + nums[c] == nums[d]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }


    public int countQuadruplets2(int[] nums) {
        int n = nums.length, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a = 1; a < n - 2; a++) {
            for (int b = 0; b < a; b++) {
                int temp = nums[a] + nums[b];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }

            for (int c = a + 2; c < n; c++) {
                int temp = nums[c] - nums[a + 1];
                count += map.getOrDefault(temp, 0);
            }
        }

        return count;
    }
}