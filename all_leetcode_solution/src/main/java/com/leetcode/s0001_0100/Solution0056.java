package com.leetcode.s0001_0100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 */
public class Solution0056 {
    public static void main(String[] args) {
        Solution0056 obj = new Solution0056();
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = obj.merge(arr);
        System.out.println(Arrays.deepToString(res));

        System.out.println("----------------------------");
        int[][] arr2 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res2 = obj.merge2(arr2);
        System.out.println(Arrays.deepToString(res2));

    }

    public int[][] merge(int[][] intervals) {
        //根据左端值对数组排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (res.isEmpty() || res.get(res.size() - 1)[1] < L) {
                //为空或者前一个数组的右边界值小于当前值的左边距，说明范围不重复
                res.add(new int[]{L, R});
            } else {
                //区间重复，更新右边界值，在这两个数组中选一个最大的值作为右边界
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }
        //将list转为数组
        return res.toArray(new int[0][]);
    }

    public int[][] merge2(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        // 对起点终点进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }
}