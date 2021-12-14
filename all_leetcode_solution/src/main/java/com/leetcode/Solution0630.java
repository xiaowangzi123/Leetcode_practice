package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：wyq
 * @date ：Created in 2021/9/19
 * @description： 课程表 III
 */
public class Solution0630 {
    public static void main(String[] args) {
        Solution0630 obj = new Solution0630();
        System.out.println(obj.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
        System.out.println(obj.scheduleCourse(new int[][]{{3, 2}, {4, 3}}));
    }

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int t = 0;
        for (int[] a : courses) {
            if (a[0] + t <= a[1]) {
                t += a[0];
                pq.offer(a[0]);
            } else {
                if (!pq.isEmpty() && pq.peek() > a[0]) {
                    t = t - pq.poll() + a[0];
                    pq.offer(a[0]);
                }
            }
        }
        return pq.size();
    }

}