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
        System.out.println(obj.isRectangleCover(rectangles));
        System.out.println(obj.isRectangleCover2(rectangles));
    }

    /**
     * 矩形区域中不能有空缺，即矩形区域的面积等于所有矩形的面积之和；
     * 矩形区域中不能有相交区域。
     */
    public boolean isRectangleCover(int[][] rectangles) {
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

        //最外围矩阵四个点坐标
        long a = getPoint(minX, maxB);
        long b = getPoint(maxA, maxB);
        long c = getPoint(minX, minY);
        long d = getPoint(maxA, minY);
        //如果面积不相等，或者最外围四个点出现次数不为1，返回false
        if (area != (long) (maxA - minX) * (maxB - minY)
                || map.getOrDefault(a, 0) != 1
                || map.getOrDefault(b, 0) != 1
                || map.getOrDefault(c, 0) != 1
                || map.getOrDefault(d, 0) != 1) {
            return false;
        }

        //删除最外围坐标点
        map.remove(a);
        map.remove(b);
        map.remove(c);
        map.remove(d);

        //剩余坐标点出现的次数为2或4，其他次数返回false
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

    public boolean isRectangleCover2(int[][] rectangles) {
        long area = 0;
        int minX = rectangles[0][0], minY = rectangles[0][1];
        int maxA = rectangles[0][2], maxB = rectangles[0][3];
        Map<String, Integer> map = new HashMap<>();
        for (int[] rect : rectangles) {
            int x = rect[0], y = rect[1], a = rect[2], b = rect[3];
            area += (long) (a - x) * (b - y);

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxA = Math.max(maxA, a);
            maxB = Math.max(maxB, b);

            String point1 = x + "-" + y;
            String point2 = x + "-" + b;
            String point3 = a + "-" + y;
            String point4 = a + "-" + b;

            map.put(point1, map.getOrDefault(point1, 0) + 1);
            map.put(point2, map.getOrDefault(point2, 0) + 1);
            map.put(point3, map.getOrDefault(point3, 0) + 1);
            map.put(point4, map.getOrDefault(point4, 0) + 1);
        }

        //最外围矩阵四个点坐标
        String a = minX + "-" + maxB;
        String b = maxA + "-" + maxB;
        String c = minX + "-" + minY;
        String d = maxA + "-" + minY;
        //如果面积不相等，或者最外围四个点出现次数不为1，返回false
        if (area != (long) (maxA - minX) * (maxB - minY)
                || map.getOrDefault(a, 0) != 1
                || map.getOrDefault(b, 0) != 1
                || map.getOrDefault(c, 0) != 1
                || map.getOrDefault(d, 0) != 1) {
            return false;
        }

        //删除最外围坐标点
        map.remove(a);
        map.remove(b);
        map.remove(c);
        map.remove(d);

        //剩余坐标点出现的次数为2或4，其他次数返回false
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value != 2 && value != 4) {
                return false;
            }
        }
        return true;
    }
}
