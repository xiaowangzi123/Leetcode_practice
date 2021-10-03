package com.leetcode.array;

import java.util.Arrays;

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
        for (int i=0; i<count.length; i++) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        return arr1;
    }
}