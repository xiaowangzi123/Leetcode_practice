package com.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author :wyq
 * @date ：Created in 2021/10/31
 * @description : 日期之间隔几天cxxc
 */
public class Solution1360 {
    public static void main(String[] args) {
        Solution1360 obj = new Solution1360();
//        String date1 = "2019-06-29", date2 = "2019-06-30";
        String date1 = "2020-01-15", date2 = "2019-12-31";
        System.out.println(obj.daysBetweenDates(date1, date2));
    }

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getSumsOfDate(date1) - getSumsOfDate(date2));
    }


    public boolean isLeapYear(int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    public int getSumsOfDate(String date) {
        String[] d = date.split("-");
        int count = 0, year = Integer.valueOf(d[0]), month = Integer.valueOf(d[1]), day = Integer.valueOf(d[2]);
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            months[1] = 29;
        }
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                count += 366;
            } else {
                count += 365;
            }
        }

        for (int i = 1; i < month; i++) {
            count += months[i - 1];
        }

        count += day;
        return count;
    }

}