package com.leetcode;

import java.util.Arrays;

/**
 * @author :wyq
 * @date ：Created in 2021/11/24
 * @description : 使每位学生都有座位的最少移动次数
 */
public class Solution2037 {
    public static void main(String[] args) {
        Solution2037 obj = new Solution2037();
        int[] seats = {3, 1, 5}, students = {2, 7, 4};
        System.out.println(obj.minMovesToSeat(seats, students));
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            count += Math.abs(seats[i] - students[i]);
        }
        return count;
    }
}