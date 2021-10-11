package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :wyq
 * @date ：Created in 2021/10/11
 * @description :
 */
public class Solution0819 {
    public static void main(String[] args) {
        Solution0819 obj = new Solution0819();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        String regex = ",\\s+|\\s+|,|\\.";
//        String regex = "\\.|,|,\\s+|\\s+";
//        String regex = "([,][^(,\\\\s)])+";
        String[] strs = paragraph.split(regex);
        System.out.println(Arrays.toString(strs));

    }

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>(banned.length);
        for (String str : banned) {
            banSet.add(str);
        }

        //分割字符串
        String regex = ",|，|\\s+";


        return null;
    }
}