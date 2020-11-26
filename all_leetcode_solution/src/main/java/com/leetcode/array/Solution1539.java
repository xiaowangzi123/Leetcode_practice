package com.leetcode.array;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        Integer[] arr2 = {1, 2, 3, 4, 7, 11};
        List<Integer> test = Arrays.asList(arr2);

        /**
         * Arrays.asList()方法却有其局限性，如果传入的参数是一个数组，那么这个数组一定要是引用类型才能将其转换为List集合，
         * 当传入基本数据类型数组时则会将这个数组对象当成一个引用类型对象存进List集合
         *
         * 使用asList()方法后，不能增删操作
         */
   /*     String [] strArr = {"刘雯","胡歌","杜鹃","邓伦"};//原数组元素
        List<String> list = Arrays.asList(strArr);*/

        System.out.println(obj.findKthPositive(arr, 2));
        System.out.println(obj.findKthPositive2(arr, 2));
    }


    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - i - 1 >= k) {
                return i + k;
            }
        }
        return arr.length + k;
    }

    public int findKthPositive2(int[] arr, int k) {
        int n = arr.length;
        int end = k + arr[n - 1];

        /*List<Integer> list = new ArrayList();
        for (int i : arr) list.add(i);*/
        /*Integer[] arr1 = ArrayUtils.toObject(arr);
        List<Integer> list = Arrays.asList(arr1);*/

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

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

