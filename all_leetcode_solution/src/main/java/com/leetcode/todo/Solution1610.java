package com.leetcode.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: wyq
 * @create time: 2021/12/16
 * @description: 可见点的最大数目
 * TODO
 */
public class Solution1610 {
    public static void main(String[] args) {
        Solution1610 obj = new Solution1610();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(3);
        List<List<Integer>> points = new ArrayList<>();
        points.add(list1);
        points.add(list2);
        points.add(list3);
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);
        System.out.println(obj.visiblePoints(points,90,location));
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameCnt = 0;
        List<Double> polarDegrees = new ArrayList<>();
        int locationX = location.get(0);
        int locationY = location.get(1);
        for (int i = 0; i < points.size(); ++i) {
            int x = points.get(i).get(0);
            int y = points.get(i).get(1);
            if (x == locationX && y == locationY) {
                sameCnt++;
                continue;
            }
            Double degree = Math.atan2(y - locationY, x - locationX);
            polarDegrees.add(degree);
        }
        Collections.sort(polarDegrees);

        int m = polarDegrees.size();
        for (int i = 0; i < m; ++i) {
            polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);
        }

        int maxCnt = 0;
        Double toDegree = angle * Math.PI / 180;
        for (int i = 0; i < m; ++i) {
            int iteration = binarySearch(polarDegrees, polarDegrees.get(i) + toDegree, false);
            maxCnt = Math.max(maxCnt, iteration - i);
        }
        return maxCnt + sameCnt;
    }

    public int binarySearch(List<Double> nums, Double target, boolean lower) {
        int left = 0, right = nums.size() - 1;
        int ans = nums.size();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) > target || (lower && nums.get(mid) >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}