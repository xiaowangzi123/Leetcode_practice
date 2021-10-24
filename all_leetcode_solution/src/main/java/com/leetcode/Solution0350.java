package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/9
 * @description : 两个数组的交集 II
 */
public class Solution0350 {
    public static void main(String[] args) {
        Solution0350 obj = new Solution0350();
//        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println(Arrays.toString(obj.intersect(nums1, nums2)));
        System.out.println(Arrays.toString(obj.intersect2(nums1, nums2)));
        System.out.println(Arrays.toString(obj.intersect3(nums1, nums2)));
        System.out.println("----------------------------");


    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length, n2 = nums2.length;
        int[] ans = new int[n1];

        int count = 0, i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                ans[count++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(ans, 0, count);
    }

    //效率不如第一个
    public int[] intersect2(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(nums1[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (list.contains(nums2[i])) {
                res.add(nums2[i]);
                list.remove(list.indexOf(nums2[i]));
            }
        }

//        return res.stream().mapToInt(i -> i).toArray();
        int[] arr = new int[res.size()];
        for (int x = 0; x < res.size(); x++) {
            arr[x] = (int) res.get(x);
        }
        return arr;
    }

    public int[] intersect3(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[nums1.length + nums2.length];
        int index = 0;
        for (int num : nums2) {
            int n = map.getOrDefault(num, 0);
            if (n > 0) {
                ans[index++] = num;
                n--;
                if (n > 0) {
                    map.put(num, n);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}