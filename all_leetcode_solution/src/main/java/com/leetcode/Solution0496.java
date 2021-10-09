package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/8
 * @description :
 */
public class Solution0496 {
    public static void main(String[] args) {
        Solution0496 obj = new Solution0496();
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(obj.nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(obj.nextGreaterElement2(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums) {
        int n1 = nums1.length, n2 = nums.length;
        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums1[i] == nums[j]) {
                    int k = j + 1;
                    for (; k < n2; k++) {
                        if (nums1[i] < nums[k]) {
                            res[i] = nums[k];
                            break;
                        }
                    }
                    if (k == n2) {
                        res[i] = -1;
                    }
                }
            }
        }
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}