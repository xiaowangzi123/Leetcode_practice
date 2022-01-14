package com.leetcode;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/14
 * @description: 查找和最小的K对数字
 */
public class Solution0373 {
    public static void main(String[] args) {
        Solution0373 obj = new Solution0373();
        System.out.println(obj.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(obj.kSmallestPairs2(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}, 8));
        System.out.println(obj.kSmallestPairs11(new int[]{1, 7}, new int[]{2}, 3));
    }

    /**
     * 添加所有元素会超时
     * 数组有序，数组长度比k大，也只需要取前k个元素
     */
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

    /**
     * 这个不能直接添加元素，索引无法确定
     */
    public List<List<Integer>> kSmallestPairs11(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1) - b.get(0) - b.get(1)));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.add(Arrays.asList(nums1[i], nums1[0]));
        }
        int index = 0;
        while (k > 0 && !pq.isEmpty()) {
            List<Integer> temp = pq.poll();
            ans.add(temp);
            if (index + 1 < nums2.length) {
                pq.add(Arrays.asList(nums1[temp.get(0)], nums2[index + 1]));
            }
            k--;
        }
        return ans;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.add(new int[]{i, 0});
        }
        while (k > 0 && !pq.isEmpty()) {
            int[] index = pq.poll();
            ans.add(Arrays.asList(nums1[index[0]], nums2[index[1]]));
            if (index[1] + 1 < nums2.length) {
                pq.add(new int[]{index[0], index[1] + 1});
            }
            k--;
        }
        return ans;
    }


}