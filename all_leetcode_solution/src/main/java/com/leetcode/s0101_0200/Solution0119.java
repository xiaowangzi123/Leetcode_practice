package com.leetcode.s0101_0200;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角 II
 */
public class Solution0119 {
    public static void main(String[] args) {
        Solution0119 obj = new Solution0119();
        System.out.println(obj.getRow4(3));
//        System.out.println(obj.getRow4(4));
//        System.out.println(obj.getRow4(5));
//        System.out.println(obj.getRow4(6));
    }

    /**
     * 遍历
     */
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
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
                if (j == 0) {
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
        int[] res = new int[rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            res[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                res[j] = res[j] + res[j - 1];
            }
        }
        //int[]转list，需要apache的commons-lang3包
        return Arrays.asList(ArrayUtils.toObject(res));
        //java8以上版本可用lambda表达式，装箱操作
//        return Arrays.stream(res).boxed().collect(Collectors.toList());

        /*list转int[]*/
        //方法一：
//        Integer[] intArr =  list.toArray(new Integer[list.size()]);
        //方法二：java8及以上版本
//        int[] intArr1 =  list.stream().mapToInt(Integer::valueOf).toArray();

    }

    public List<Integer> getRow4(int rowIndex) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            arr.add(0, 1);
            for (int j = 1; j < arr.size() - 1; j++) {
                arr.set(j, arr.get(j) + arr.get(j + 1));
            }
        }
        return arr;
    }
}