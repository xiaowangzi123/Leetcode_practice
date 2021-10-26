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
        System.out.println(obj.countBinarySubstrings("00110001111"));
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
        }

        return count;
    }
}