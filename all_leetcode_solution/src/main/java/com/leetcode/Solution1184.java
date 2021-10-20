package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/20
 * @description : 公交站间的距离
 */
public class Solution1184 {
    public static void main(String[] args) {
        Solution1184 obj = new Solution1184();
        int[] distance = {1, 2, 3, 4};
        int[] distance2 = {7, 10, 1, 12, 11, 14, 5, 0};
        System.out.println(obj.distanceBetweenBusStops(distance, 0, 1));
        System.out.println(obj.distanceBetweenBusStops(distance2, 7, 2));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int d1 = 0, d2 = 0, sum = 0, n = distance.length;
        for (int i = 0; i < n; i++) {
            sum += distance[i];
        }
        for (int i = start; i != destination; i = (i + 1) % n) {
            d1 += distance[i];
        }
        d2 = sum - d1;
        return d1 > d2 ? d2 : d1;
    }

    public int distanceBetweenBusStops2(int[] distance, int start, int destination) {
        int n = distance.length;
        if (start == destination) return 0;
        int d1 = 0;
        for (int i = start; i != destination; i = (i + 1) % n) { //计算start到destination的距离
            d1 += distance[i];
        }
        int d2 = 0;
        for (int i = destination; i != start; i = (i + 1) % n) { //计算destination到start的距离
            d2 += distance[i];
            if (d2 >= d1) return d1;
        }
        return d2;
    }
}