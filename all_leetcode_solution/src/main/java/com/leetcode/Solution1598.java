package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/11/6
 * @description : 文件夹操作日志搜集器
 */
public class Solution1598 {
    public static void main(String[] args) {
        Solution1598 obj = new Solution1598();
        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
        System.out.println(obj.minOperations(logs));
        System.out.println(logs[2].equals("../"));
    }

    public int minOperations(String[] logs) {
        int count = 0;
        for (String s : logs) {
            if (count > 0 && s.equals("../")) {
                count--;
            } else if (s.charAt(0) != '.') {
                count++;
            }
        }
        return count;
    }
}