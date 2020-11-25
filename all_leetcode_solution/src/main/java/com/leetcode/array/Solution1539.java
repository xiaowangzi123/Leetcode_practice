package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1539 {

    public static void main(String[] args) {
        Solution1539 obj = new Solution1539();
//        int[] arr = {2, 3, 4, 7, 11};
        int[] arr = {1, 2, 3, 4, 7, 11};
        System.out.println(obj.findKthPositive(arr, 2));
        System.out.println(obj.findKthPositive2(arr, 5));
    }


    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - i - 1 >= k) {
                return k + i;
            }
        }
        return k + arr.length;
    }

    public int findKthPositive2(int[] arr, int k) {
        int n = arr.length;
        int end = k + arr[n - 1];
        List<Integer> list = new ArrayList();

        for (int i : arr) list.add(i);
        int res = -1;
        for (int i = 1; i <= end; i++) {
            if (list.indexOf(i) < 0) k--;
            if (k == 0) {
                res = i;
                break;
            }
        }
        return res;
    }
}

