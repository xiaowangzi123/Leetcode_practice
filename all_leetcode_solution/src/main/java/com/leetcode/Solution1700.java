package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/12
 * @description : 无法吃午餐的学生数量
 */
public class Solution1700 {
    public static void main(String[] args) {
        Solution1700 obj = new Solution1700();
        int[] students = {1, 1, 0, 0}, sandwiches = {0, 1, 0, 1};
        System.out.println(obj.countStudents(students, sandwiches));
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            if (students[i] == 0) {
                ans[0]++;
            }else {
                ans[1]++;
            }
            if (sandwiches[i]==0){
                ans[0]--;
            }else {
                ans[1]--;
            }
        }

        return Math.abs(ans[0]) + Math.abs(ans[1]);
    }
}