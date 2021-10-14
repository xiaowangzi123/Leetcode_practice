package com.leetcode;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/16
 * @description :第三大的数
 */
public class Solution0414 {
    public static void main(String[] args) {
        Solution0414 obj = new Solution0414();
        int[] arr = {1, 2, 3, 1};
        System.out.println("-----------{1, 2, 3, 1}----------------");
        System.out.println("1:" + obj.thirdMax2(arr));

        int[] arr2 = {1, 2, -2147483648};
        System.out.println("-----------{1, 2, -2147483648}----------------");
        System.out.println("-2147483648:" + obj.thirdMax2(arr2));

        int[] arr3 = {1, 2};
        System.out.println("------{1, 2} ---------------------");
        System.out.println("2:" + obj.thirdMax2(arr3));

        int[] arr4 = {1, -2147483648, -2147483648};
        System.out.println("------{1, -2147483648，-2147483648} ---------------------");
        System.out.println("1:" + obj.thirdMax2(arr4));

        int[] arr5 = {1, 1, 2};
        System.out.println("------{1, 2,1} ---------------------");
        System.out.println("2:" + obj.thirdMax2(arr5));

        int[] arr6 = {2, 2, 3, 1};
        System.out.println("------{2, 2, 3,1} ---------------------");
        System.out.println("1:" + obj.thirdMax2(arr6));
    }



    public int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE, c = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > a) {
                c = b;
                b = a;
                a = i;
            } else if (i > b && i < a) {
                c = b;
                b = i;
            } else if (i > c && i < b) {
                c = i;
            }
        }
        System.out.println("abc:" + a + "=" + b + "=" + c);
        if (b == c) {
            return a;
        } else {
            return c;
        }
    }

    public int thirdMax2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int a = 0;
        Integer[] arr = new Integer[set.size()];
        for (int i : set) {
            arr[a++] = i;
        }
        /*Arrays.sort(arr, new Comparator<Integer>() {
            public int compare ( Integer a, Integer b){
                return a - b;
            }
        });*/

        System.out.println(Arrays.toString(arr));
        //考虑Integer.MIN_VALUE被减后的越界问题
//        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        } else {
            return arr[2];
        }
    }

    public int thirdMax3(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : nums) {
            treeSet.add(i);
            if (treeSet.size() > 3) {
                treeSet.remove(treeSet.first());
            }
        }
        return treeSet.size()==3?treeSet.first():treeSet.last();
    }
}