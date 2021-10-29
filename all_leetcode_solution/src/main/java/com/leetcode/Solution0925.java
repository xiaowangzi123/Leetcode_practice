package com.leetcode;

/**
 * @author :wyq
 * @date ：Created in 2021/10/29
 * @description : 长按键入
 */
public class Solution0925 {
    public static void main(String[] args) {
        Solution0925 obj = new Solution0925();
//        String name = "alex", typed = "aaleex";
        String name = "saeed", typed = "ssaaeeedd";
//        String name = "laiden", typed = "laidene";
        System.out.println(obj.isLongPressedName(name, typed));
    }

    /**
     * typed字符有且只有两种「用途」：
     * 作为name 的一部分。匹配name 中的一个字符
     * 作为长按键入的一部分。此时它应当与前一个字符相同。否则就返回false
     *
     * 当i < name长度，且i 和 j 指向的字符相同，那么i和j都往后移动一位
     * 当j大于0，且 j 和 j - 1 所指的元素相同，表示为重复的字符，j右移一位
     * 当以上两种情况不满足时，终止循环直接返回False
     *
     */
    public boolean isLongPressedName(String name, String typed) {
        int index = 0, index2 = 0;
        while (index2 < typed.length()) {
            if (index < name.length() && name.charAt(index) == typed.charAt(index2)) {
                index++;
                index2++;
            }else if (index2>0 && typed.charAt(index2)==typed.charAt(index2-1)){
                index2++;
            }else {
                return false;
            }
        }
        return index == name.length();
    }
}