package com.leetcode;

import java.util.Arrays;

/**
 * @author: wyq
 * @create time: 2021/12/22
 * @description: 重复叠加字符串匹配
 */
public class Solution0686 {
    public static void main(String[] args) {
        Solution0686 obj = new Solution0686();
        System.out.println(obj.repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(obj.repeatedStringMatch("a", "a"));
        System.out.println(obj.repeatedStringMatch("a", "aa"));
        System.out.println(obj.repeatedStringMatch("abc", "wxyz"));
        System.out.println(obj.repeatedStringMatch("abc", ""));
    }


    public int repeatedStringMatch(String a, String b) {
        int m = a.length(), n = b.length(),ans =1;
        StringBuilder sb = new StringBuilder(a);
        while (sb.length() <= m * 2 + n) {
            int index = sb.indexOf(b);
            if (index>=0){
                return ans;
            }
            ans++;
            sb.append(a);
        }
        return -1;
    }


}