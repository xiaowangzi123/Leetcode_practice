package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author :wyq
 * @date ：Created in 2021/11/5
 * @description : 重新排列单词间的空格
 */
public class Solution1592 {
    public static void main(String[] args) {
        Solution1592 obj = new Solution1592();
        String text = "  this   is  a sentence ";
        System.out.println(obj.reorderSpaces(text));
    }

    public String reorderSpaces(String text) {
        List<String> list = new ArrayList<>();
        int space = 0, n = text.length();
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == ' ') {
                space++;
            } else {
                int j = i + 1;
                while (j < n && text.charAt(j) != ' ') {
                    j++;
                }
                list.add(text.substring(i, j));
                i = j - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (list.size() == 1) {
            sb.append(list.get(0));
            for (int i = 0; i < space; i++) {
                sb.append(' ');
            }
        } else {
            int num = space / (list.size() - 1);
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                for (int j = 0; j < num; j++) {
                    sb.append(' ');
                    space--;
                }
            }
            for (int i = 0; i < space; i++) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}