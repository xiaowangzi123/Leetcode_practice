package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/10/12
 * @description :可以输入的最大单词数
 */
public class Solution1935 {
    public static void main(String[] args) {
        Solution1935 obj = new Solution1935();
        String text = "hello world", brokenLetters = "ad";

        System.out.println(obj.canBeTypedWords(text, brokenLetters));
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        String[] str = text.split(" ");
        for (String s : str) {
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (brokenLetters.contains(ch + "")) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }


    public int canBeTypedWords2(String text, String brokenLetters) {
        int count = 0;
        boolean flag = true;
        for (char ch : text.toCharArray()) {
            if (brokenLetters.contains(ch + "")) {
                //找到单词中的不能输入字母
                flag = false;
            } else if (ch == ' ') {
                //为空说明某一单词检索结束
                if (flag) {
                    count++;
                }
                flag = false;
            }
            /*if (flag) {
                count++;
            }*/
        }
        // 判断最后一个单词状态并更新数目
        if (flag) {
            count++;
        }
        return count;
    }


}