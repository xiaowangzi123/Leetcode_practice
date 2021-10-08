package com.leetcode;

import java.util.*;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/15
 * @description：
 */
public class Solution0015 {
    public static void main(String[] args) {
        Solution0015 obj = new Solution0015();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = obj.threeSum(arr);

        //List遍历方式
        System.out.println("-------增强for--------------");
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

        System.out.println("-------for--------------");
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }

        System.out.println("-------Iterator--------------");
        Iterator<List<Integer>> it = lists.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("-------ListIterator--------------");
        ListIterator<List<Integer>> listIt = lists.listIterator();
        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }

        System.out.println("-------Lambda--------------");
        lists.forEach(item -> System.out.println(item));
    }

    /**
     * 算法流程：
     * 1.对于数组长度n，如果数组为 null或者数组长度小于3，返回[]。
     * 2.对数组进行排序。
     * 3.遍历排序后数组：
     * 3.1若nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于0，直接返回结果。
     * 3.2对于重复元素：跳过，避免出现重复解
     * 3.3令左指针L=i+1，右指针R=n−1，当L<R 时，执行循环：
     * 当nums[i]+nums[L]+nums[R]==0，执行循环，
     * 判断左界和右界是否和下一位置重复，去除重复解。并同时将L,R 移到下一位置，寻找新的解
     * 若和大于0，说明nums[R]太大，R左移
     * 若和小于0，说明nums[L]太小，L右移
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        //双指针
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) {
                return lists;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr = nums[i];
            int L = i + 1, R = len - 1;
            while (L < R) {
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while (L < R && nums[L + 1] == nums[L]) {
                        L++;
                    }
                    while (L < R && nums[R - 1] == nums[R]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (tmp < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return lists;
    }
}