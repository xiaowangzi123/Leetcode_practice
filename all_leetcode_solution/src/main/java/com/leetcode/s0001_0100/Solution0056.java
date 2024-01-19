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
        System.out.println("length:"+arr.length);
        System.out.println(Arrays.deepToString(res));
        System.out.println(res[2][1]);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println("----------------------------");
        int[][] arr2 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res2 = obj.merge2(arr2);
        System.out.println(Arrays.deepToString(res2));

    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //根据左端值对数组排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (res.isEmpty() || res.get(res.size() - 1)[1] < L) {
                res.add(new int[]{L, R});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }
        return res.toArray(new int[0][]);
    }

    public int[][] merge2(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }
        // 对起点终点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
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