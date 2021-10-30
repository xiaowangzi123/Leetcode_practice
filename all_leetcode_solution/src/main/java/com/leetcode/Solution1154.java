package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/30
 * @description : 一年中的第几天
 */
public class Solution1154 {
    public static void main(String[] args) {
        Solution1154 obj = new Solution1154();
//        String date = "2019-01-09";
        String date = "2004-03-01";
        System.out.println(obj.dayOfYear(date));
    }

    /**
     * 四百年一润；四年一润，百年不润；
     */
    public int dayOfYear(String date) {
        String[] d = date.split("-");
        int count = 0, year = Integer.valueOf(d[0]), month = Integer.valueOf(d[1]), day = Integer.valueOf(d[2]);
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            months[1] = 29;
        }
        for (int i = 1; i < month; i++) {
            count += months[i - 1];
        }
        count += day;
        return count;
    }
}