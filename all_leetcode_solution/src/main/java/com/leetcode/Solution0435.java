package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/17
 * @description：
 */
public class Solution0435 {
    public static void main(String[] args) {
        Solution0435 obj = new Solution0435();
        int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] arr2 = {{1, 2}, {1, 2}, {1, 2}, {1, 2}};
        System.out.println(obj.eraseOverlapIntervals(arr2));
//        System.out.println(obj.eraseOverlapIntervals2(arr));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        //cannot be cast to java.lang.Comparable
//        Arrays.sort(intervals, Collections.reverseOrder());

        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        //上面的简写模式
//        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        /**
         *先根据数组第一个数大小进行升序排列
         * 设定第一个数组的右边界值，跟下一个数组的左边界值比较
         * 如果右边界值小，说明没有重叠，继续查找
         * 如果右边界值大，说明有重叠，选择两个数组中最小的右边界值
         */
        int count = 0, right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (right <= intervals[i][0]) {
                right = intervals[i][1];
            } else {
                right = Math.min(right, intervals[i][1]);
                count++;
            }
        }
        return count;
    }

}