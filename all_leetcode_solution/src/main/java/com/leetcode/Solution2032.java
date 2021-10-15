package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/15
 * @description : 至少在两个数组中出现的值
 */
public class Solution2032 {
    public static void main(String[] args) {
        Solution2032 obj = new Solution2032();
        int[] nums1 = {1, 1, 3, 2}, nums2 = {2, 3}, nums3 = {3};
        System.out.println(obj.twoOutOfThree(nums1, nums2, nums3));
        System.out.println(obj.twoOutOfThree2(nums1, nums2, nums3));

    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        for (int num : nums3) {
            set3.add(num);
        }

        set2.retainAll(set3);
        set.retainAll(set2);
        return ans;
    }

    public List<Integer> twoOutOfThree2(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();

        int[] count = new int[101];
        int[] count2 = new int[101];
        int[] count3 = new int[101];

        for (int num : nums1) {
            count[num] = 1;
        }
        for (int num : nums2) {
            count2[num] = 1;
        }
        for (int num : nums3) {
            count3[num] = 1;
        }
        for (int i = 1; i < 101; i++) {
            if (count[i] + count2[i] + count3[i] > 1) {
                ans.add(nums1[i]);
            }
        }
        return ans;
    }
}