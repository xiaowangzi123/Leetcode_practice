package com.leetcode;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/10
 * @description :
 */
public class Solution0645 {
    public static void main(String[] args) {
        Solution0645 obj = new Solution0645();
//        int[] arr = {1, 2, 2, 4};
//        int[] arr = {1, 1};
        int[] arr = {3, 2, 3, 4, 6, 5};
        System.out.println(Arrays.toString(obj.findErrorNums(arr)));
    }

    public int[] findErrorNums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        //添加多余的数据
        for (int num : nums) {
            if (!set.add(num)) {
                ans.add(num);
            }
        }

        //找出缺失的数据
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i+1)) {
                ans.add(i + 1);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}