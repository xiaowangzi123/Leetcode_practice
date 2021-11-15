package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/16
 * @description : 完美矩形
 */
public class Solution0391 {
    public static void main(String[] args) {
        Solution0391 obj = new Solution0391();
        int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        System.out.println(obj.isRectangleCover2(rectangles));
    }

    /**
     * 矩形区域中不能有空缺，即矩形区域的面积等于所有矩形的面积之和；
     * 矩形区域中不能有相交区域。
     */
//    public boolean isRectangleCover(int[][] rectangles) {
//        long area = 0;
//        int minX = rectangles[0][0], minY = rectangles[0][1];
//        int maxA = rectangles[0][2], maxB = rectangles[0][3];
//        Map<Point, Integer> map = new HashMap<>();
//        for (int[] rect : rectangles) {
//            int x = rect[0], y = rect[1], a = rect[2], b = rect[3];
//            area += (long) (a - x) * (b - y);
//
//            minX = Math.min(minX, x);
//            minY = Math.min(minY, y);
//            maxA = Math.max(maxA, a);
//            maxB = Math.max(maxB, b);
//
//            Point point1 = new Point(x, y);
//            Point point2 = new Point(x, b);
//            Point point3 = new Point(a, y);
//            Point point4 = new Point(a, b);
//
//            map.put(point1, map.getOrDefault(point1, 0) + 1);
//            map.put(point2, map.getOrDefault(point2, 0) + 1);
//            map.put(point3, map.getOrDefault(point3, 0) + 1);
//            map.put(point4, map.getOrDefault(point4, 0) + 1);
//        }
//
//        Point pointMinMin = new Point(minX, minY);
//        Point pointMinMax = new Point(minX, maxB);
//        Point pointMaxMin = new Point(maxA, minY);
//        Point pointMaxMax = new Point(maxA, maxB);
//        if (area != (long) (maxA - minX) * (maxB - minY) || map.getOrDefault(pointMinMin, 0) != 1 || map.getOrDefault(pointMinMax, 0) != 1 || map.getOrDefault(pointMaxMin, 0) != 1 || map.getOrDefault(pointMaxMax, 0) != 1) {
//            return false;
//        }
//
//        map.remove(pointMinMin);
//        map.remove(pointMinMax);
//        map.remove(pointMaxMin);
//        map.remove(pointMaxMax);
//
//        for (Map.Entry<Point, Integer> entry : map.entrySet()) {
//            int value = entry.getValue();
//            if (value != 2 && value != 4) {
//                return false;
//            }
//        }
//        return true;
//    }

/*class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point point2 = (Point) obj;
            return this.x == point2.x && this.y == point2.y;
        }
        return false;
    }*/
    public boolean isRectangleCover2(int[][] rectangles) {
        long area = 0;
        int minX = rectangles[0][0], minY = rectangles[0][1];
        int maxA = rectangles[0][2], maxB = rectangles[0][3];
        Map<Long, Integer> map = new HashMap<>();
        for (int[] rect : rectangles) {
            int x = rect[0], y = rect[1], a = rect[2], b = rect[3];
            area += (long) (a - x) * (b - y);

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxA = Math.max(maxA, a);
            maxB = Math.max(maxB, b);

            long point1 = getPoint(x, y);
            long point2 = getPoint(x, b);
            long point3 = getPoint(a, y);
            long point4 = getPoint(a, b);

            map.put(point1, map.getOrDefault(point1, 0) + 1);
            map.put(point2, map.getOrDefault(point2, 0) + 1);
            map.put(point3, map.getOrDefault(point3, 0) + 1);
            map.put(point4, map.getOrDefault(point4, 0) + 1);
        }

        //矩阵四个点坐标
        long a = getPoint(minX, maxB);
        long b = getPoint(maxA, maxB);
        long c = getPoint(minX, minY);
        long d = getPoint(maxA, minY);
        if (area != (long) (maxA - minX) * (maxB - minY)
                || map.getOrDefault(a, 0) != 1
                || map.getOrDefault(b, 0) != 1
                || map.getOrDefault(c, 0) != 1
                || map.getOrDefault(d, 0) != 1) {
            return false;
        }

        map.remove(a);
        map.remove(b);
        map.remove(c);
        map.remove(d);

        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value != 2 && value != 4) {
                return false;
            }
        }
        return true;
    }

    public long getPoint(int x, int y) {
        return (long) (x + 100000) * 200001 + (long) (y + 100000);
    }
}
