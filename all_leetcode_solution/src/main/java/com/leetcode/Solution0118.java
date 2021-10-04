package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/16
 * @description : 杨辉三角
 */
public class Solution0118 {
    public static void main(String[] args) {
        Solution0118 obj = new Solution0118();
        System.out.println(obj.generate(4));
        System.out.println(obj.generate(4).get(3));
        System.out.println("-------------------");

        System.out.println(obj.generate2(4));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        res.add(arr);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            List<Integer> pre = res.get(res.size() - 1);
            for (int j = 1; j < i - 1; j++) {
                list.add(pre.get(j - 1) + pre.get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            arr.add(0, 1);

            for (int j = 1; j < arr.size() - 1; ++j) {
                arr.set(j, arr.get(j) + arr.get(j + 1));
            }
            res.add(new ArrayList<>(arr));
        }

        return res;
    }

}