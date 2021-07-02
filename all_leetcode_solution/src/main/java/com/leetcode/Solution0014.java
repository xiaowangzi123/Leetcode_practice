package com.leetcode;

import java.util.Arrays;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description： // * {@link Solution0898}
 */
public class Solution0014 {
    public static void main(String[] args) {
        Solution0014 obj = new Solution0014();
        /*String[] str = {"flower", "flow", "flight"};
        System.out.println(obj.longestCommonPrefix(str));

        String[] str2 = {"dog", "abc", "high"};
        System.out.println(obj.longestCommonPrefix(str2));
*/
        String[] str3 = {"abc", "ab"};
        System.out.println(obj.longestCommonPrefix(str3));
        System.out.println("abc".charAt(1));
    }

    public String longestCommonPrefix(String[] strs) {
        //字符数组长度为零，直接返回
        /**
         *
         */
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 0; i < res.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || res.charAt(i) != strs[j].charAt(i)) {
                    return res.substring(0, i);
                }
            }
        }
        return res;
    }


}