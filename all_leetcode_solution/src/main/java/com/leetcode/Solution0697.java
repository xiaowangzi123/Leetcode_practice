package com.leetcode;

import com.leetcode.bean.Employee;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :
 */
public class Solution0697 {
    public static void main(String[] args) {
        Solution0697 obj = new Solution0697();
//        int[] arr = {1, 2, 2, 3, 1};
        int[] arr={1,2,2,3,1,4,2};
        System.out.println(obj.findShortestSubArray(arr));

    }

    //可以简单理解为，找数组中包含众数的最小序列，求长度
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        //map中key保存元素值，int[]三个值分别保存元素个数、第一次出现index、最后一次出现index
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }

        int max = 0, length = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            int temp = arr[2] - arr[1] + 1;
            if (max < arr[0]) {
                max = arr[0];
                length = temp;
            } else if (max == arr[0]) {
                if (length > temp) {
                    length = temp;
                }
            }
        }
        return length;
    }
}