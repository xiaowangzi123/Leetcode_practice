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
        System.out.println(obj.dayOfTheWeek(21, 12, 1980));
        System.out.println(obj.dayOfTheWeek(1, 1, 1971));
        System.out.println(obj.dayOfTheWeek(3, 1, 2022));
        System.out.println(obj.dayOfTheWeek(31, 8, 2019));
        System.out.println(obj.dayOfTheWeek(18, 7, 1999));
        System.out.println(obj.dayOfTheWeek(15, 8, 1993));

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
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && month >= 3) {
            count++;
        }

        //日贡献天数
        count += day;

        return week[(count + 4) % 7];
    }

}