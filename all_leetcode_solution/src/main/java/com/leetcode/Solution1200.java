package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/21
 * @description : 最小绝对差
 */
public class Solution1200 {
    public static void main(String[] args) {
        Solution1200 obj = new Solution1200();
//        int[] arr = {4, 2, 1, 3};
        int[] arr = {40, 11, 26, 27, -20};
        System.out.println(obj.minimumAbsDifference(arr));
        System.out.println(obj.minimumAbsDifference2(arr));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            int temp = arr[i] - arr[i - 1];
            if (temp < min) {
                min = temp;
                ans.clear();
                list.add(arr[i - 1]);
                list.add(arr[i]);
            } else if (temp == min) {
                list.add(arr[i - 1]);
                list.add(arr[i]);
            }
            if (list.size() > 0) {
                ans.add(list);
            }
        }
        return ans;
    }


    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            int temp = arr[i] - arr[i - 1];
            if (temp > min) {
                continue;
            } else if (temp < min) {
                min = temp;
                ans.clear();
            }
            list.add(arr[i - 1]);
            list.add(arr[i]);

            if (list.size() > 0) {
                ans.add(list);
            }
        }
        return ans;
    }
}