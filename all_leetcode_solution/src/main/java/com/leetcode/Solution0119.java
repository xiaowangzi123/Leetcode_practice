package com.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        System.out.println(obj.getRow3(3));
        System.out.println(obj.getRow4(3));
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
                    row.add(list.get(j - 1) + list.get(j));
                }
            }
            list = row;
        }
        return list;
    }

    public List<Integer> getRow3(int rowIndex) {
        int[] res = new int[rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            res[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                res[j] = res[j]+res[j-1];
            }
        }
        return Arrays.asList(ArrayUtils.toObject(res));
    }

    public List<Integer> getRow4(int rowIndex) {
        int[] res = new int[rowIndex+1];
        for (int i = 0; i <= rowIndex; i++) {
            res[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                res[j] = res[j]+res[j-1];
            }
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}