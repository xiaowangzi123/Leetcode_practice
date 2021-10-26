package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/26
 * @description : 学生出勤记录 I
 */
public class Solution0551 {
    public static void main(String[] args) {
        Solution0551 obj = new Solution0551();
        String s = "PPALLLP";
        System.out.println(obj.checkRecord(s));

    }

    public boolean checkRecord(String s) {
        int absent = 0, late = 0;
        for (char ch : s.toCharArray()) {
            if ('A' == ch) {
                absent++;
                late = 0;
                if (absent > 1) {
                    return false;
                }
            } else if ('L' == ch) {
                late++;
                if (late >= 3) {
                    return false;
                }
            } else {
                late = 0;
            }
        }

        return true;
    }
}