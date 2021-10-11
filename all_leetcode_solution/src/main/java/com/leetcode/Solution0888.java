package com.leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0888 {
    public static void main(String[] args) {
        Solution0888 obj = new Solution0888();
        int[] arr = {1, 2, 5}, arr2 = {2, 4};

        System.out.println(Arrays.toString(obj.fairCandySwap(arr, arr2)));

        System.out.println(Arrays.stream(arr).sum());
        System.out.println(Arrays.stream(arr).count());
        System.out.println(Collections.singletonList(arr).contains(2));
        System.out.println(Arrays.asList(Arrays.stream(arr).boxed().toArray(Integer[]::new)).contains(2));
        System.out.println(Arrays.asList(arr).contains(3));
        System.out.println("-------------------");
        System.out.println(useList(arr, 2));
        System.out.println(ArrayUtils.contains(arr, 2));
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sum1 = Arrays.stream(aliceSizes).sum();
        int sum2 = Arrays.stream(bobSizes).sum();
        int[] ans = new int[2];

        return null;
    }

    public static boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    public static boolean useList(int[] arr, int targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    public static boolean useSet(String[] arr, String targetValue) {
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        return set.contains(targetValue);
    }

    //适合查找已经排序过的数组
    public static boolean useArraysBinarySearch(String[] arr, String targetValue) {
        int a = Arrays.binarySearch(arr, targetValue);
        return a > 0;
    }
}