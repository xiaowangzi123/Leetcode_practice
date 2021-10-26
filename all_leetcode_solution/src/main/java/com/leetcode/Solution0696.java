package com.leetcode;

import javax.swing.plaf.SliderUI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :wyq
 * @date ：Created in 2021/10/26
 * @description : 计数二进制子串
 */
public class Solution0696 {
    public static void main(String[] args) {
        Solution0696 obj = new Solution0696();
        System.out.println(obj.countBinarySubstrings("101"));
        System.out.println(obj.countBinarySubstrings("00110011"));
        System.out.println(obj.countBinarySubstrings2("00110011"));
        System.out.println(obj.countBinarySubstrings3("00110011"));
    }

    /**
     * 构造一个列表，值为当前字符连续的个数
     */
    public int countBinarySubstrings(String s) {
        int count = 0, index = 0;
        List<Integer> list = new ArrayList<>();
        char temp = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (temp == s.charAt(i)) {
                index++;
            } else {
                list.add(index);
                temp = s.charAt(i);
                index = 1;
            }
            if (i == s.length() - 1) {
                list.add(index);
            }
        }

        for (int i = 1; i < list.size(); i++) {
            count += Math.min(list.get(i - 1), list.get(i));
        }
        return count;
    }

    public int countBinarySubstrings2(String s) {
        List<Integer> list = new ArrayList<>();
        int index = 0, n = s.length();
        while (index < n) {
            int count = 0;
            char temp = s.charAt(index);
            while (index < n && temp == s.charAt(index)) {
                index++;
                count++;
            }
            list.add(count);
        }
        int ans = 0;
        for (int i = 1; i < list.size(); i++) {
            ans += Math.min(list.get(i - 1), list.get(i));
        }
        return ans;
    }

    public int countBinarySubstrings3(String s) {
        int ans = 0, index = 0, pre = 0, n = s.length();
        while (index < n) {
            int count = 0;
            char temp = s.charAt(index);
            while (index < n && temp == s.charAt(index)) {
                index++;
                count++;
            }
            ans += Math.min(pre, count);
            pre = count;
        }
        return ans;
    }
}