package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2022/1/9
 * @description : 面试题 01.05. 一次编辑
 */
public class Interview0105 {
    public static void main(String[] args) {
        Interview0105 obj = new Interview0105();
        System.out.println(obj.oneEditAway("waterbottle", "erbottlewat"));
        System.out.println(obj.oneEditAway("abc", "cba"));
    }

    public boolean oneEditAway(String first, String second) {
        int len = first.length() - second.length();
        if (len > 1 || len < -1) {
            return false;
        }
        int count = 1;
        for (int i = 0, j = 0; i < first.length() && j < second.length(); i++, j++) {
            if (first.charAt(i) != second.charAt(j)) {
                //second要不要添加一个字符
                if (len == 1) {
                    j--;
                } else if (len == -1) {
                    //second要不要删除一个字符
                    i--;
                }
                count--;
            }
            //最多编辑一次
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}