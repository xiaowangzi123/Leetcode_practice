package com.leetcode;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/18
 * @description: 最小时间差
 */
public class Solution0539 {
    public static void main(String[] args) {
        Solution0539 obj = new Solution0539();
        List<String> list = new ArrayList<>(Arrays.asList("23:59", "00:00", "12:34"));
        System.out.println(obj.findMinDifference2(list));
        System.out.println(obj.getDiff("00:00", "12:01"));
    }

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, (o1, o2) -> o1.compareTo(o2));
        int n = timePoints.size();
        int ans = getMinter(timePoints.get(n - 1)) - getMinter(timePoints.get(0));
        ans = ans > 720 ? 1440 - ans : ans;

        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, getMinter(timePoints.get(i + 1)) - getMinter(timePoints.get(i)));
            ans = ans > 720 ? 1440 - ans : ans;
        }

        return ans;
    }

    public int getMinter(String s) {
        int minter = 0;
        minter += ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0')) * 60;
        minter += (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
        return minter;
    }


    public int findMinDifference2(List<String> timePoints) {
        Collections.sort(timePoints, (o1, o2) -> o1.compareTo(o2));
        int n = timePoints.size();
        int ans = getDiff(timePoints.get(0), timePoints.get(n-1));

        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, getDiff(timePoints.get(i), timePoints.get(i + 1)));
        }
        return ans;
    }

    public int getDiff(String s1, String s2) {
        int minter = 0;
        minter += ((s2.charAt(0) - s1.charAt(0)) * 10 + (s2.charAt(1) - s1.charAt(1))) * 60;
        minter += (s2.charAt(3) - s1.charAt(3)) * 10 + (s2.charAt(4) - s1.charAt(4));
        return minter > 720 ? 1440 - minter : minter;
    }
}