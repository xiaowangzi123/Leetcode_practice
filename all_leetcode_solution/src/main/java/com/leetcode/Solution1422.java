package com.leetcode;

import javax.swing.event.MouseInputAdapter;

/**
 * @author :wyq
 * @date ：Created in 2021/11/3
 * @description : 分割字符串的最大得分
 */
public class Solution1422 {
    public static void main(String[] args) {
        Solution1422 obj = new Solution1422();
        System.out.println(obj.maxScore("011101"));
    }

    public int maxScore(String s) {
        int count = 0, index = 0;
        while (s.charAt(index) == '0') {
            index++;
        }
        count = index;
        for (int i=index;i<s.length();i++){
            if (s.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}