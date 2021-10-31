package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/1
 * @description : 转变日期格式
 */
public class Solution1507 {
    public static void main(String[] args) {
        Solution1507 obj = new Solution1507();
        String date = "20th Oct 2052";
        System.out.println(obj.reformatDate(date));
    }

    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            map.put(months[i - 1], i);
        }
        String[] array = date.split(" ");
        int year = Integer.parseInt(array[2]);
        int month = map.get(array[1]);
        int day = Integer.parseInt(array[0].substring(0, array[0].length() - 2));
        StringBuilder sb = new StringBuilder();
        sb.append(year).append("-").append(month).append("-").append(day);
//        return String.format("%d-%02d-%02d", year, month, day);
        return sb.toString();
    }
}