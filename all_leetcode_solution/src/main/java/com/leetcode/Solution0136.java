package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/14
 * @description：
 */
public class Solution0136 {
    public static void main(String[] args) {
        Solution0136 obj = new Solution0136();
        int[] arr = {1, 2, 1, 4, 2};
        System.out.println(obj.singleNumber(arr));
        System.out.println(obj.singleNumber2(arr));
    }

    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.add(i)){
                set.remove(i);
            }
        }
        Iterator iterator = set.iterator();
        return (int) iterator.next();
    }

    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}