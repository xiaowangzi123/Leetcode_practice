package com.leetcode.date;

import sun.reflect.misc.ConstructorUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author: wyq
 * @create time: 2022/1/3
 * @description: 一周中的第几天
 * 1970 年 12 月 31 日是星期四
 */
public class Solution1185 {
    public static void main(String[] args) {
        Solution1185 obj = new Solution1185();
        System.out.println(obj.dayOfTheWeek(1, 1, 1972));
        System.out.println(obj.dayOfTheWeek(3, 1, 2022));

    }


    public String dayOfTheWeek(int day, int month, int year) {
        int count = 0;
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};

        //年贡献天数
        count = (year - 1971) * 365;
        for (int i = 1971; i < year; i++) {
            if ((i % 400 == 0) || (i % 4 == 0 && i % 100 != 0)) {
                count++;
            }
        }

        //月贡献天数
        for (int i = 0; i < month - 1; i++) {
            count += months[i];
        }

        //日贡献天数
        count += day;

        return week[(count + 4) % 7];
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


    public int dayOfYear3(String date) {
        String[] d = date.split("-");
        int count = 0, year = Integer.valueOf(d[0]), month = Integer.valueOf(d[1]), day = Integer.valueOf(d[2]);
        switch (month) {
            case 12:
                count += 30;
            case 11:
                count += 31;
            case 10:
                count += 30;
            case 9:
                count += 31;
            case 8:
                count += 31;
            case 7:
                count += 30;
            case 6:
                count += 31;
            case 5:
                count += 30;
            case 4:
                count += 31;
            case 3:
                if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                    count += 29;
                } else {
                    count += 28;
                }
            case 2:
                count += 31;
            default:
                break;
        }
        count += day;
        return count;
    }
}