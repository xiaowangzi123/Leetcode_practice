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
//        String date = "20th Oct 2052";
        String date = "6th Jun 1933";
        System.out.println(obj.reformatDate(date));
    }

    public String reformatDate(String date) {
        String[][] months = {{"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"},
                {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}};
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 12; i++) {
            map.put(months[0][i], months[1][i]);
        }
        String[] arr = date.split(" ");
        String year = arr[2];
        String month = map.get(arr[1]);
        String day = arr[0].substring(0, arr[0].length() - 2);
        StringBuilder sb = new StringBuilder();
        sb.append(year).append("-").append(month).append("-");
        if (day.length()==1){
            sb.append('0').append(day);
        }else {
            sb.append(day);
        }
//        return String.format("%d-%02d-%02d", year, month, day);
        return sb.toString();
    }
}