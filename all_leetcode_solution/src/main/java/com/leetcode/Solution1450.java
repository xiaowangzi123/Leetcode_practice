package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/9
 * @description : 在既定时间做作业的学生人数
 */
public class Solution1450 {
    public static void main(String[] args) {
        Solution1450 obj = new Solution1450();
        int[] startTime = {1, 2, 3}, endTime = {3, 2, 7};
        System.out.println(obj.busyStudent(startTime, endTime, 4));
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                count++;
            }
        }
        return count;
    }
}