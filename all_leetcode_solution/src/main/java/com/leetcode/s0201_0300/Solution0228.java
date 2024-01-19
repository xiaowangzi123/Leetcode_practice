package com.leetcode.s0201_0300;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间汇总
 */
public class Solution0228 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5, 6, 7, 9};
        Solution0228 obj = new Solution0228();
        System.out.println(obj.summaryRanges(arr));

        //测试“”和String.valueOf()速度
        long t1 = System.currentTimeMillis();
        List<String> arr1 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arr1.add(String.valueOf(i));
        }
        long t2 = System.currentTimeMillis();
        List<String> arr2 = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            arr1.add(i + "");
        }
        long t3 = System.currentTimeMillis();
        System.out.println((t2 - t1) + ":" + (t3 - t2));

    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < nums.length) {
            int num = nums[i];
            while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num == nums[i]) {
                res.add(String.valueOf(num));
            } else {
                res.add(num + "->" + nums[i]);
            }
            i = i + 1;
        }

        return res;
    }
}