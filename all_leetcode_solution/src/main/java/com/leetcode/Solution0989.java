package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/19
 * @description :数组形式的整数加法
 */
public class Solution0989 {
    public static void main(String[] args) {
        Solution0989 obj = new Solution0989();
//        int[] num = {1, 2, 0, 0};
//        int k = 34;
        int[] num = {2, 1, 5};
        int k = 806;
        System.out.println(obj.addToArrayForm(num, k));
        System.out.println("---------------------");

    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int index = num.length - 1, temp = 0;
        while (index >= 0 || k > 0) {
            int i = index >= 0 ? num[index] : 0;
            int j = k % 10;
            ans.add((i + j + temp) % 10);
            temp = (i + j + temp) / 10;
            index--;
            k /= 10;
        }
        if (temp==1){
            ans.add(1);
        }
        Collections.reverse(ans);
        return ans;
    }
}