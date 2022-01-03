package com.leetcode.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author :wyq
 * @date ：Created in 2021/10/31
 * @description : 日期之间隔几天
 */
public class Solution1360 {
    public static void main(String[] args) {
        Solution1360 obj = new Solution1360();
//        String date1 = "2019-06-29", date2 = "2019-06-30";
//        String date1 = "2020-01-15", date2 = "2019-12-31";
        String date1 = "2023-01-13", date2 = "2044-02-11";
        System.out.println(obj.daysBetweenDates(date1, date2));
        System.out.println(obj.daysBetweenDates2(date1, date2));
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
        int year = Integer.valueOf(d[0]);
        int month = Integer.valueOf(d[1]);
        int day = Integer.valueOf(d[2]);
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            months[1] = 29;
        }

        int count = 0;
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


    //效率并没有实质的变化，反而增加了空间开销
    public int daysBetweenDates2(String date1, String date2) {
        String[] d1 = date1.split("-"), d2 = date2.split("-");
        int year1 = Integer.valueOf(d1[0]), year2 = Integer.valueOf(d2[0]);
        int month1 = Integer.valueOf(d1[1]), month2 = Integer.valueOf(d2[1]);
        int day1 = Integer.valueOf(d1[2]), day2 = Integer.valueOf(d2[2]);
        int start = Math.min(year1, year2);
        return Math.abs(getSumsOfDate(start, year1, month1, day1) - getSumsOfDate(start, year2, month2, day2));
    }

    public int getSumsOfDate(int start, int year, int month, int day) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            months[1] = 29;
        }

        int count = 0;
        for (int i = start; i < year; i++) {
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