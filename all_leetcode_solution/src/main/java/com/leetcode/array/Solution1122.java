package com.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description：
 */
public class Solution1122 {

    public static void main(String[] args) {
        Solution1122 obj = new Solution1122();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(obj.relativeSortArray(arr1, arr2)));
        //输出序列安装arr2排序，arr1中剩余元素从小到大排序
        //[2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19]
    }


    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] count = new int[1001];
        // 遍历arr1中的元素并计数,统计个元素出现个数
        for (int num : arr1) {
            count[num]++;
        }

        int index = 0;
        // 处理arr2中的元素
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[index++] = num;
                count[num]--;
            }
        }

        // 处理剩余不是arr2中的元素
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        return arr1;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Collections.sort(list, (x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

    public int[] relativeSortArray3(int[] arr1, int[] arr2) {
        Map<Integer, Integer> numPostions = IntStream.range(0, arr2.length).boxed().collect(Collectors.toMap(i -> arr2[i], i -> i));
        return Arrays.stream(arr1).boxed().sorted((o1, o2) -> {
            int a1 = numPostions.getOrDefault(o1, 1001);
            int a2 = numPostions.getOrDefault(o2, 1001);
            if (a1 != 1001 || a2 != 1001) {
                return a1 - a2;
            }

            return o1 - o2;
        }).mapToInt(o -> o).toArray();
    }
}