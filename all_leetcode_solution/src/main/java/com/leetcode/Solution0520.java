package com.leetcode;

import javafx.beans.binding.When;

/**
 * @author :wyq
 * @date ：Created in 2021/10/24
 * @description : 检测大写字母
 */
public class Solution0520 {
    public static void main(String[] args) {
        Solution0520 obj = new Solution0520();
//        System.out.println(obj.detectCapitalUse("D"));
        System.out.println(obj.detectCapitalUse("D"));
    }

    /**
     * 找不符合条件的
     * 第1个字符为大写，后面有小写的返回false；
     * 同样第个为小写，后面出现大写字母也返回false
     * 第1个是大写，第0个不能出现小写
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        boolean flag = Character.isUpperCase(word.charAt(1));
        for (int i = 0; i < word.length(); i++) {
            if (flag) {
                if (i != 1 && Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            } else {
                if (i > 1 && Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}