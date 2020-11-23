package com.leetcode.array;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1395 {

    public static void main(String[] args) {
        Solution1395 obj = new Solution1395();
        int[] arr = {2, 5, 3, 4, 1};
        System.out.println(obj.numTeams(arr));
    }


    public int numTeams(int[] a) {
        int count = 0, len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if ((a[i] > a[j] && a[j] > a[k]) || (a[i] < a[j] && a[j] < a[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


}