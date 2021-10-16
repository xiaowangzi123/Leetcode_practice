package com.leetcode;

import java.security.interfaces.ECKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/15
 * @description :相对名次
 */
public class Solution0506 {
    public static void main(String[] args) {
        Solution0506 obj = new Solution0506();
        //["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
//        int[] arr = {5, 4, 3, 2, 1};

        //["Gold Medal","5","Bronze Medal","Silver Medal","4"]
        int[] arr = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(obj.findRelativeRanks(arr)));


        //不能用同一个测试用例，调用上述方法后，对数组进行了排序
        int[] arr2 = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(obj.findRelativeRanks2(arr2)));

    }

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        //保存分数和位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }
        //分数排序
        Arrays.sort(score);
        int j = n - 1;
        while (j >= 0) {
            //排序后，第j位的值
            int num = score[j];
            //排序前，值对应的索引
            int index = map.get(num);
            if (j == n - 1) {
                ans[index] = "Gold Medal";
            } else if (j == n - 2) {
                ans[index] = "Silver Medal";
            } else if (j == n - 3) {
                ans[index] = "Bronze Medal";
            } else {
                ans[index] = n - j + "";
            }
            j--;
        }
        return ans;
    }

    public String[] findRelativeRanks2(int[] score) {
        int n = score.length;
        String[] ans = new String[n];
        int[] clone = Arrays.copyOf(score, n);
        Arrays.sort(clone);
        for (int i = 0; i < score.length; i++) {
            int rank = n - Arrays.binarySearch(clone, score[i]);
            if (rank == 1) {
                ans[i] = "Gold Medal";
            } else if (rank == 2) {
                ans[i] = "Silver Medal";
            } else if (rank == 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = Integer.toString(rank);
            }
        }
        return ans;
    }

}