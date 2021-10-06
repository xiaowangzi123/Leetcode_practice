package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/6
 * @description :
 */
public class Solution0128 {
    public static void main(String[] args) {
        Solution0128 obj = new Solution0128();
        int[] arr = {100, 4, 200, 1, 3, 2};
        int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] arr3 = {};
        int[] arr4 = {0, -1};

//        System.out.println(obj.longestConsecutive(arr));
//        System.out.println(obj.longestConsecutive(arr2));
//        System.out.println(obj.longestConsecutive(arr3));
        System.out.println(obj.longestConsecutive(arr4));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int count = 0, temp = set.first();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != temp) {
                return count - 1;
            }
            temp++;
            count++;
        }
        return count;
    }
}