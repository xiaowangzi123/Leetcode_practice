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
//        String[] str3 = {"abc", "ab"};
        String[] str3 = {"a", "b"};
        System.out.println(obj.longestCommonPrefix(str3));
    }

    public String longestCommonPrefix(String[] strs) {
        /**
         * 字符数组长度为零，直接返回
         * 纵向遍历每个字符串，从前往后遍历所有字符串的每一列
         * 比较相同列上的字符是否相同
         * 相同继续对下一列进行比较；不同时，当前字符串之前的部分就是最长公共前缀
         */

        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 0; i < res.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                //i == strs[j].length()表示strs[j]长度遍历结束
                if (i == strs[j].length() || res.charAt(i) != strs[j].charAt(i)) {
                    return res.substring(0, i);
                }
            }
        }
        return res;
    }


}