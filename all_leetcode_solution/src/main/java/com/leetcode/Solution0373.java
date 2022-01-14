package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: wyq
 * @create time: 2022/1/14
 * @description: 查找和最小的K对数字
 */
public class Solution0373 {
    public static void main(String[] args) {
        Solution0373 obj = new Solution0373();
        System.out.println(obj.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(obj.kSmallestPairs(new int[]{1, 7}, new int[]{2}, 3));
    }

    //超时
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k, (a, b) -> (a.get(0) + a.get(1) - b.get(0) - b.get(1)));
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < Math.min(k, m); i++) {
            for (int j = 0; j < Math.min(k, n); j++) {
                List<Integer> temp = new ArrayList<>(Arrays.asList(nums1[i], nums2[j]));
                pq.add(temp);
            }
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            ans.add(pq.poll());
        }
        return ans;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(k, (a, b) -> (a.get(0) + a.get(1) - b.get(0) - b.get(1)));
        int m = nums1.length, n = nums2.length;
        for (int i = 0; i < k && i < Math.min(m * n, k); i++) {
            ans.add(pq.poll());
        }
        return ans;
    }
}