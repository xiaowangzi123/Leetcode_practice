package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：wyq
 * @date ：Created in 2020/11/21
 * @description：
 */
public class Solution1309 {
    public static void main(String[] args) {
        Solution1309 obj = new Solution1309();
        String s = "12345678910#11#";
//        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        System.out.println((char)('a'+1));
        System.out.println(obj.freqAlphabets(s));
    }

    public String freqAlphabets(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '#') return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((i + 2) < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char) ('a' + Integer.parseInt(s.substring(i, i + 2)) - 1));
                i += 2;
            } else {
                sb.append((char) ('a' + Integer.parseInt(s.substring(i, i + 1)) - 1));
            }
        }
        return sb.toString();
    }


}