package com.leetcode.backtrace;

import java.util.*;

/**
 * @author: wyq
 * @create time: 2022/1/18
 * @description: TODO
 */
public class Solution0401 {
    public static void main(String[] args) {
        Solution0401 obj = new Solution0401();
        System.out.println(obj.readBinaryWatch(1));
    }

    int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        backtrack(num, 0, 0, 0);
        return res;
    }

    public void backtrack(int num, int index, int hour, int minute) {
        if (hour > 11 || minute > 59) {
            return;
        }
        if (num == 0) {
            /*StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());*/
            res.add(hour+":" + (minute < 10 ? "0" : "") + minute);
            return;
        }
        for (int i = index; i < 10; i++) {
            backtrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }

    public List<String> readBinaryWatch2(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    ans.add(i + ":" + (j < 10 ? "0" : "") + j);
                }
            }
        }
        return ans;
    }


}