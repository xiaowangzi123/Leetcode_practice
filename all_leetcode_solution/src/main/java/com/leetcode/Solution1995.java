package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 统计特殊四元组
 */
public class Solution1995 {
    public static void main(String[] args) {
        Solution1995 obj = new Solution1995();
        System.out.println(obj.countQuadruplets(new int[]{1, 2, 3, 6}));
        System.out.println(obj.countQuadruplets(new int[]{3, 3, 6, 4, 5}));
        System.out.println(obj.countQuadruplets(new int[]{1, 1, 1, 3, 5}));
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

}