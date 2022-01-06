package com.leetcode;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/19
 * @description : 括号的最大嵌套深度
 */
public class Solution1614 {

    public static void main(String[] args) {
        Solution1614 obj = new Solution1614();
        String str = "()()";
        System.out.println(obj.maxDepth(str));
    }


    public int maxDepth(String s) {
        int maxDeep = 0, deep = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deep++;
            } else if (s.charAt(i) == ')') {
                deep--;
            }
            maxDeep = Math.max(maxDeep, deep);
        }
        return maxDeep;
    }


}