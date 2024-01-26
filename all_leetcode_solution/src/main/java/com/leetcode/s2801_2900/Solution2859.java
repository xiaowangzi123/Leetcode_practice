package com.leetcode.s2801_2900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 计算 K 置位下标对应元素的和
 */
public class Solution2859 {
    public static void main(String[] args) {
        Solution2859 solution = new Solution2859();
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(5, 10, 1, 5, 2));
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(4,3,2,1));
        List<Integer> nums3 = new ArrayList<>(Arrays.asList(3, 2, 5, 5, 2, 3));
        System.out.println(solution.sumIndicesWithKSetBits(nums1, 1));
        System.out.println(solution.sumIndicesWithKSetBits(nums2, 2));
    }

    //Integer.bitCount(i)

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (k == Integer.bitCount(i)) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    public int sumIndicesWithKSetBits2(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            String s = Integer.toBinaryString(i);
            if (k == count(s)) {
                sum += nums.get(i);
            }
        }

        return sum;

    }

    public int count(String num) {
        int countOnes = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '1') {
                countOnes++;
            }
        }
        return countOnes;
    }
}
