package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/16
 * @description：
 */
public class Solution0119 {
    public static void main(String[] args) {
        Solution0119 obj = new Solution0119();
        System.out.println(obj.getRow(3));
        System.out.println(obj.getRow2(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(row);
        }
        return lists.get(rowIndex);
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(list.get(j-1)+list.get(j));
                }
            }
            list = row;
        }
        return list;
    }
}