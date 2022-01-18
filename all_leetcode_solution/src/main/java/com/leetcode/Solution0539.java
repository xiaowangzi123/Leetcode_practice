package com.leetcode;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/18
 * @description: 最小时间差
 */
public class Solution0539 {
    public static void main(String[] args) {
        Solution0539 obj = new Solution0539();
        List<String> list = new ArrayList<>(Arrays.asList("23:59","00:00","12:34"));
        System.out.println(obj.findMinDifference(list));
        System.out.println("23:59".compareTo("00:00"));
    }

    public int findMinDifference(List<String> timePoints) {
        int ans=Integer.MAX_VALUE;
        Collections.sort(timePoints, (o1, o2) -> o1.compareTo(o2));


        return ans;
    }


}