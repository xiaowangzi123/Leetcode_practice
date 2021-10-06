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
        int[] arr5 = {9, 1, 10, 7, 11, 2, 0, 5, 8, -1, 6};

        System.out.println("4==" + obj.longestConsecutive(arr));
        System.out.println("9==" + obj.longestConsecutive(arr2));
        System.out.println("0==" + obj.longestConsecutive(arr3));
        System.out.println("2==" + obj.longestConsecutive(arr4));
        System.out.println("6==" + obj.longestConsecutive(arr5));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int count = 0;

        /*for (int i : set) {
            if (i != temp) {
                return count;
            }
            temp++;
            count++;
        }*/

        /*Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != temp) {
                return count - 1;
            }
            temp++;
            count++;
        }*/

        for (int i : set) {
            if (!set.contains(i - 1)) {
                int temp = i;
                int curCount = 1;
                while (set.contains(++temp)) {
//                    temp++;
                    curCount++;
                }
                count = Math.max(count, curCount);
            }
        }
        return count;
    }

    /**
     * 找到x,x+1,x+2……x+y的子序列。
     * 如果存在x-1值，则应该从x-1遍历
     */
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int temp = num;
                int curCount = 1;
                while (set.contains(temp + 1)) {
                    temp ++;
                    curCount ++;
                }
                count = Math.max(count, curCount);
            }
        }

        return count;
    }

}