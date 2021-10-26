package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/8
 * @description : 下一个更大元素
 */
public class Solution0496 {
    public static void main(String[] args) {
        Solution0496 obj = new Solution0496();
        int[] nums1 = {4, 1, 2}, nums2 = {1, 3, 4, 2};
//        int[] nums1 = {7, 1, 2}, nums2 = {2, 3, 5, 1, 0, 7, 6};
        System.out.println(Arrays.toString(obj.nextGreaterElement(nums1, nums2)));
        System.out.println(Arrays.toString(obj.nextGreaterElement2(nums1, nums2)));
        System.out.println(Arrays.toString(obj.nextGreaterElement3(nums1, nums2)));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                //找出nums1[i]在nums2中出现的位置j
                if (nums1[i] == nums2[j]) {
                    int k = j + 1;
                    for (; k < n2; k++) {
                        //从相同元素的下一位置j+1开始遍历，找到第一个大于当前元素的值，并结束当前循环
                        if (nums1[i] < nums2[k]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                    //找不到大于当前元素的值，赋值为-1
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
        //key为当前元素值，value为比当前元素大的下一个元素值
        Map<Integer, Integer> map = new HashMap<>(n2);

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

    public int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {
            int j = 0;
            while (j < n2 && nums1[i] != nums2[j]) {
                j++;
            }
            j++;
            while (j < n2 && nums2[j] < nums1[i]) {
                j++;
            }
            res[i] = j < n2 ? nums2[j] : -1;
        }
        return res;
    }
}