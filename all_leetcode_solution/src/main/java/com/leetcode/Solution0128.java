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
        int[] arr6 = {2};
        int[] arr7 = {0, 1, 1, 2};

        /*System.out.println("4==" + obj.longestConsecutive2(arr));
        System.out.println("9==" + obj.longestConsecutive2(arr2));
        System.out.println("0==" + obj.longestConsecutive2(arr3));
        System.out.println("2==" + obj.longestConsecutive2(arr4));
        System.out.println("7==" + obj.longestConsecutive2(arr5));
        System.out.println("1==" + obj.longestConsecutive2(arr6));
        System.out.println("3==" + obj.longestConsecutive2(arr7));

        System.out.println("---------------------------");
        System.out.println("4==" + obj.longestConsecutive3(arr));
        System.out.println("9==" + obj.longestConsecutive3(arr2));
        System.out.println("0==" + obj.longestConsecutive3(arr3));
        System.out.println("2==" + obj.longestConsecutive3(arr4));
        System.out.println("7==" + obj.longestConsecutive3(arr5));
        System.out.println("1==" + obj.longestConsecutive3(arr6));
        System.out.println("3==" + obj.longestConsecutive3(arr7));*/

        System.out.println("4==" + obj.longestConsecutive4(arr));
        System.out.println("9==" + obj.longestConsecutive4(arr2));
        System.out.println("0==" + obj.longestConsecutive4(arr3));
        System.out.println("2==" + obj.longestConsecutive4(arr4));
        System.out.println("7==" + obj.longestConsecutive4(arr5));
        System.out.println("1==" + obj.longestConsecutive4(arr6));
        System.out.println("3==" + obj.longestConsecutive4(arr7));
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
                    temp++;
                    curCount++;
                }
                count = Math.max(count, curCount);
            }
        }

        return count;
    }

    //重复问题没有解决
    public int longestConsecutive3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int j = i, tempCount = 0;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
                tempCount++;
                count = Math.max(tempCount + 1, count);
            }
        }
        return count;
    }

    //超时
    public int longestConsecutive4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }

        List<Integer> list = new ArrayList<>(set);
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            int j = i, tempCount = 0;
            while (j < list.size() && list.get(j) == list.get(j - 1) + 1) {
                j++;
                tempCount++;
                count = Math.max(tempCount + 1, count);
            }
        }
        return count;
    }
}